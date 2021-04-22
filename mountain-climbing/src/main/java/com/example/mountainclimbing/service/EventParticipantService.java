package com.example.mountainclimbing.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.mountainclimbing.model.EventParticipant;
import com.example.mountainclimbing.repository.EventParticipantRepository;

@Service
public class EventParticipantService {

	private final EventParticipantRepository eventParticipantRepository;
	
	public EventParticipantService(EventParticipantRepository eventParticipantRepository) {
		this.eventParticipantRepository = eventParticipantRepository;
	}
	
	public EventParticipant createEventParticipant(EventParticipant eventParticipant) {
		return 	eventParticipantRepository.save(eventParticipant);
	}
	
	public Optional<EventParticipant> readEventParticipant(Integer id) {
		return  eventParticipantRepository.findById(id);
	}
	
	
	public Optional<EventParticipant> updateEventParticipant(Integer id,EventParticipant eventParticipant) {
		if(eventParticipantRepository.existsById(id)) {
			return Optional.ofNullable(eventParticipantRepository.save(eventParticipant));
		}
		return Optional.empty();
	}
	
	
	public boolean deleteEventParticipant(Integer id) {
		if(eventParticipantRepository.existsById(id)) {
			eventParticipantRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public Integer countEventParticipant(Integer id) {
		return eventParticipantRepository.countByEventId(id);
	}
}
