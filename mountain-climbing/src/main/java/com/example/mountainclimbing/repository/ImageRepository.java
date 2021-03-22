package com.example.mountainclimbing.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mountainclimbing.model.Image;

@Repository 
public interface ImageRepository extends CrudRepository<Image, Integer> {

}
