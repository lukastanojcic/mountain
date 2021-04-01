package com.example.mountainclimbing.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.mountainclimbing.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
