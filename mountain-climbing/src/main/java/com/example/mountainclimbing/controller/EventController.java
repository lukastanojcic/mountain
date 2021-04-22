package com.example.mountainclimbing.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mountainclimbing.model.Event;
import com.example.mountainclimbing.service.EventService;


@RestController
@RequestMapping("/event")
public class EventController {
	
private final EventService eventService;
	
	public EventController(EventService eventService) {
		this.eventService = eventService;
	}
	
	
	
	@PostMapping
	public  ResponseEntity<Event> createEvent(@Valid @RequestBody Event event,BindingResult result) {
		Event data = eventService.createEvent(event);
		if(result.hasErrors()) {
			return new ResponseEntity<Event>(HttpStatus.BAD_REQUEST);
		}
		if(data != null) {
			return new ResponseEntity<Event>(event,HttpStatus.CREATED);	
		}
		else {
			return new ResponseEntity<Event>(HttpStatus.NO_CONTENT );
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Event> readEvent(@PathVariable Integer id) {
		Optional<Event> opt= eventService.readEvent(id);
		if(opt.isPresent()) {
			return new ResponseEntity<Event>(opt.get(),HttpStatus.OK);
		}
		return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Event> updateEvent(@PathVariable Integer id,@Valid @RequestBody Event event,BindingResult result){
		Optional<Event> opt = eventService.updateEvent(id, event);
		if(result.hasErrors()) {
			return new ResponseEntity<Event>(HttpStatus.BAD_REQUEST);
		}
		if(opt.isPresent()) {
			return new ResponseEntity<Event>(opt.get(),HttpStatus.OK);
		}
		return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEvent(@PathVariable Integer id) {
		boolean del = eventService.deleteEvent(id);
		if(del) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			
	}

}
