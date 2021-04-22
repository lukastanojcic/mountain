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

import com.example.mountainclimbing.model.EventParticipant;
import com.example.mountainclimbing.service.EventParticipantService;

@RestController
@RequestMapping("/eventparticipant")
public class EventParticipantController {
	
	private final EventParticipantService eventParticipantService;	
	public EventParticipantController(EventParticipantService eventParticipantService) {
		this.eventParticipantService = eventParticipantService;
	}
	
	@PostMapping
	public  ResponseEntity<EventParticipant> createEventParticipant(@Valid @RequestBody EventParticipant eventParticipant,BindingResult result) {
		EventParticipant data = eventParticipantService.createEventParticipant(eventParticipant);
		if(result.hasErrors()) {
			return new ResponseEntity<EventParticipant>(HttpStatus.BAD_REQUEST);
		}
		if(data != null) {
			return new ResponseEntity<EventParticipant>(eventParticipant,HttpStatus.CREATED);	
		}
		else {
			return new ResponseEntity<EventParticipant>(HttpStatus.NO_CONTENT );
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EventParticipant> readEventParticipant(@PathVariable Integer id) {
		Optional<EventParticipant> opt= eventParticipantService.readEventParticipant(id);
		if(opt.isPresent()) {
			return new ResponseEntity<EventParticipant>(opt.get(),HttpStatus.OK);
		}
		return new ResponseEntity<EventParticipant>(HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EventParticipant> updateEvent(@PathVariable Integer id,@Valid @RequestBody EventParticipant eventParticipant,BindingResult result){
		Optional<EventParticipant> opt = eventParticipantService.updateEventParticipant(id, eventParticipant);
		if(result.hasErrors()) {
			return new ResponseEntity<EventParticipant>(HttpStatus.BAD_REQUEST);
		}
		if(opt.isPresent()) {
			return new ResponseEntity<EventParticipant>(opt.get(),HttpStatus.OK);
		}
		return new ResponseEntity<EventParticipant>(HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEventParticipant(@PathVariable Integer id) {
		boolean del = eventParticipantService.deleteEventParticipant(id);
		if(del) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			
	}
	@GetMapping("/count/{id}")
	public Integer countEventParticipant(@PathVariable Integer id) {
		return eventParticipantService.countEventParticipant(id);
	}


}
