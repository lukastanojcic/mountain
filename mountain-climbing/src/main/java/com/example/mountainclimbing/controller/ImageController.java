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

import com.example.mountainclimbing.model.Image;
import com.example.mountainclimbing.service.ImageService;

@RestController
@RequestMapping("/image")
public class ImageController {
	
	private final ImageService imageService;
	
	public ImageController(ImageService imageService) {
		this.imageService = imageService;
	}
	
	@PostMapping
	public  ResponseEntity<Image> createImage(@Valid @RequestBody Image image,BindingResult result) {
		Image data = imageService.createImage(image);
		if(result.hasErrors()) {
			return new ResponseEntity<Image>(HttpStatus.BAD_REQUEST);
		}
		if(data != null) {
			return new ResponseEntity<Image>(image,HttpStatus.CREATED);	
		}
		else {
			return new ResponseEntity<Image>(HttpStatus.NO_CONTENT );
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Image> readImage(@PathVariable Integer id) {
		Optional<Image> opt= imageService.readImage(id);
		if(opt.isPresent()) {
			return new ResponseEntity<Image>(opt.get(),HttpStatus.OK);
		}
		return new ResponseEntity<Image>(HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Image> updateImage(@PathVariable Integer id,@Valid @RequestBody Image image,BindingResult result){
		Optional<Image> opt = imageService.updateImage(id, image);
		if(result.hasErrors()) {
			return new ResponseEntity<Image>(HttpStatus.BAD_REQUEST);
		}
		if(opt.isPresent()) {
			return new ResponseEntity<Image>(opt.get(),HttpStatus.OK);
		}
		return new ResponseEntity<Image>(HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteImage(@PathVariable Integer id) {
		boolean del = imageService.deleteImage(id);
		if(del) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			
	}

}
