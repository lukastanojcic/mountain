package com.example.mountainclimbing.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.example.mountainclimbing.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	Optional<User> findUserByUsername(String username);
	
}
