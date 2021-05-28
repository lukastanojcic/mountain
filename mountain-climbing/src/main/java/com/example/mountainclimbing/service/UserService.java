package com.example.mountainclimbing.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.validation.Valid;
import org.springframework.stereotype.Service;
import com.example.mountainclimbing.dto.UserDto;
import com.example.mountainclimbing.mapper.UserMapper;
import com.example.mountainclimbing.model.User;
import com.example.mountainclimbing.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;
	
	public UserService(UserRepository userRepository, UserMapper userMapper) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}
	
	public Optional<UserDto> createUser(UserDto userDto){
		User user = this.userMapper.dtoToEntity(userDto);
		return Optional.of(this.userMapper.entityToDto(userRepository.save(user)));
	}
	
	public Optional<UserDto> readUser(int id){
		User user = userRepository.findById(id).get();
		return Optional.of(this.userMapper.entityToDto(user));
	}
	
	public boolean deleteUser(int id) {
		if(userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public Optional<UserDto> updateUser(int id, @Valid UserDto userDto){
		if(userRepository.existsById(id)) {
			User updated = this.userMapper.dtoToEntity(userDto);
			return Optional.of(this.userMapper.entityToDto(userRepository.save(updated)));
		}
		return Optional.empty();
	}
	
	public Optional<List<UserDto>> readAllUsers(){
		Iterable<User> users = userRepository.findAll();
			
		return Optional.ofNullable(StreamSupport.stream(users.spliterator(), false)
			.map(new Function<User, UserDto>() {

				@Override
				public UserDto apply(User user) {
					return userMapper.entityToDto(user);
				}
				
			}).collect(Collectors.toList()));
	}
	
}
