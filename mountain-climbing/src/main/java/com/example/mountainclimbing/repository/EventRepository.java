package com.example.mountainclimbing.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.mountainclimbing.model.Event;

@Repository 
public interface EventRepository extends CrudRepository<Event, Integer> {

}
