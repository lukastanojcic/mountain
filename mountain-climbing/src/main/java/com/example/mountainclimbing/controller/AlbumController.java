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
import com.example.mountainclimbing.model.Album;
import com.example.mountainclimbing.service.AlbumService;

@RestController
@RequestMapping("/album")
public class AlbumController {
	
	private final AlbumService albumService;

	public AlbumController(AlbumService albumService) {
		this.albumService = albumService;
	}	
	
	@PostMapping
	public  ResponseEntity<Album> createAlbum(@Valid @RequestBody Album album, BindingResult result) {
		if(result.hasErrors()) {
			return new ResponseEntity<Album>(HttpStatus.BAD_REQUEST);
		}
		albumService.createAlbum(album);
		return new ResponseEntity<Album>(album,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Album> readAlbum(@PathVariable(value="id") int id, BindingResult result) {
		Optional<Album> opt =  albumService.readAlbum(id);
		if(opt.isPresent()) {
			return new ResponseEntity<Album>(opt.get(),HttpStatus.OK);
		}
		return new ResponseEntity<Album>(opt.get(),HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Album> updateAlbum(@PathVariable(value="id") int id,@Valid @RequestBody Album album, BindingResult result){
		if(result.hasErrors()) {
			return new ResponseEntity<Album>(HttpStatus.BAD_REQUEST);
		}
		Album al = albumService.updateAlbum(id, album);
		if(al != null) {
			return new ResponseEntity<Album>(album,HttpStatus.OK);
		}
		return new ResponseEntity<Album>(album,HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAlbum(@PathVariable(value="id") int id, BindingResult result) {
		if(result.hasErrors()) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		boolean success = albumService.deleteAlbum(id);
		if(success) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}
