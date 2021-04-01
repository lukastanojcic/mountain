package com.example.mountainclimbing.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mountainclimbing.model.User;
import com.example.mountainclimbing.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@Valid @RequestBody User user, BindingResult result){
		if(result.hasErrors()){
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		Optional<User> opt = userService.createUser(user);
		if(opt.isPresent()) {
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		}
		return new ResponseEntity<User>(opt.get(), HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<User> readUser(@PathVariable(value="id") int id, BindingResult result) {
		if(result.hasErrors()) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		Optional<User> opt =  userService.readUser(id);
		if(opt.isPresent()) {
			return new ResponseEntity<User>(opt.get(),HttpStatus.OK);
		}
		return new ResponseEntity<User>(opt.get(),HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value="id") int id,@Valid @RequestBody User user, BindingResult result){
		if(result.hasErrors()) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		Optional<User> opt = userService.updateUser(id, user);
		if(opt.isPresent()) {
			return new ResponseEntity<User>(opt.get(), HttpStatus.OK);
		}
		return new ResponseEntity<User>(opt.get(), HttpStatus.NO_CONTENT);
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
	public ResponseEntity<Iterable<User>> readAllUsers(BindingResult result) {
		if(result.hasErrors()) {
			return new ResponseEntity<Iterable<User>>(HttpStatus.BAD_REQUEST);
		}
		Optional<Iterable<User>> opt =  userService.readAllUsers();
		if(opt.isPresent()) {
			return new ResponseEntity<Iterable<User>>(opt.get(),HttpStatus.OK);
		}
		return new ResponseEntity<Iterable<User>>(opt.get(),HttpStatus.NO_CONTENT);
	}
}
