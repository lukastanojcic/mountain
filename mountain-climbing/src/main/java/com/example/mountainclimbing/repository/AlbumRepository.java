package com.example.mountainclimbing.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mountainclimbing.model.Album;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Integer>{
		
}
