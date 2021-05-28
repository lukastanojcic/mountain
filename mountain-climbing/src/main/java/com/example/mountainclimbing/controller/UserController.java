package com.example.mountainclimbing.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.mountainclimbing.dto.UserDto;
import com.example.mountainclimbing.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
	
	private final PasswordEncoder passwordEncoder;
	
	public UserController(UserService userService, PasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}
	
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto, BindingResult result){
		if(result.hasErrors()){
			return new ResponseEntity<UserDto>(HttpStatus.BAD_REQUEST);
		}
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		Optional<UserDto> opt = userService.createUser(userDto);
		if(opt.isPresent()) {
			return new ResponseEntity<UserDto>(userDto, HttpStatus.CREATED);
		}
		return new ResponseEntity<UserDto>(opt.get(), HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<UserDto> readUser(@PathVariable(value="id") int id) {
		Optional<UserDto> opt =  userService.readUser(id);
		if(opt.isPresent()) {
			return new ResponseEntity<UserDto>(opt.get(),HttpStatus.OK);
		}
		return new ResponseEntity<UserDto>(opt.get(),HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable(value="id") int id,@RequestBody UserDto userDto, BindingResult result){
		if(result.hasErrors()) {
			return new ResponseEntity<UserDto>(HttpStatus.BAD_REQUEST);
		}
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		Optional<UserDto> opt = userService.updateUser(id, userDto);
		if(opt.isPresent()) {
			return new ResponseEntity<UserDto>(opt.get(), HttpStatus.OK);
		}
		return new ResponseEntity<UserDto>(opt.get(), HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable(value="id") int id, BindingResult result) {
		if(result.hasErrors()) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		boolean success = userService.deleteUser(id);
		if(success) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<Iterable<UserDto>> readAllUsers() {
		Optional<List<UserDto>> opt =  userService.readAllUsers();
		if(opt.isPresent()) {
			return new ResponseEntity<Iterable<UserDto>>(opt.get(),HttpStatus.OK);
		}
		return new ResponseEntity<Iterable<UserDto>>(opt.get(),HttpStatus.NO_CONTENT);
	}
}
