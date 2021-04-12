package com.example.mountainclimbing.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.mountainclimbing.model.Event;
import com.example.mountainclimbing.repository.EventRepository;


@Service
public class EventService {
	
	private final EventRepository eventRepository;
	
	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	public Event createEvent(Event event) {
		return 	eventRepository.save(event);
	}
	
	public Optional<Event> readEvent(Integer id) {
		return  eventRepository.findById(id);
	}
	
	
	public Optional<Event> updateEvent(Integer id,Event event) {
		if(eventRepository.existsById(id)) {
			return Optional.ofNullable(eventRepository.save(event));
		}
		return Optional.empty();
	}
	
	
	public boolean deleteEvent(Integer id) {
		if(eventRepository.existsById(id)) {
			eventRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
