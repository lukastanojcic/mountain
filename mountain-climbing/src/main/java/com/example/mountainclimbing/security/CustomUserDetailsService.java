package com.example.mountainclimbing.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.mountainclimbing.model.User;
import com.example.mountainclimbing.repository.UserRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService{

	UserRepository userRepository;
	
	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findUserByUsername(username);
		if(user.isPresent()){
			UserDetails userDetails = user.get();
			return userDetails;
		}else {
			throw new UsernameNotFoundException("User with username: " + username + " not found!");
		}
	}

}
