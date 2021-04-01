package com.example.mountainclimbing.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import com.example.mountainclimbing.model.User;
import com.example.mountainclimbing.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public Optional<User> createUser(User user){
		return Optional.of(userRepository.save(user));
	}
	
	public Optional<User> readUser(int id){
		return userRepository.findById(id);
	}
	
	public boolean deleteUser(int id) {
		if(userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public Optional<User> updateUser(int id, @Valid User user){
		if(userRepository.existsById(id)) {
			return Optional.of(userRepository.save(user));
		}
		return Optional.empty();
	}
	
	public Optional<Iterable<User>> readAllUsers(){
		return Optional.of(userRepository.findAll());
	}
	
}
