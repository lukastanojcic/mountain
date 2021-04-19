package com.example.mountainclimbing.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mountainclimbing.model.EventParticipant;

@Repository 
public interface EventParticipantRepository extends CrudRepository<EventParticipant, Integer> {

}
