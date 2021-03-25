package com.example.mountainclimbing.controller;
import javax.validation.Valid;

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
		return imageService.createImage(image,result);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Image> readImage(@PathVariable(value="id") int id) {
		return imageService.readImage(id);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Image> updateImage(@PathVariable(value="id") int id,@Valid @RequestBody Image image,BindingResult result){
		return imageService.updateImage(id, image,result);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteImage(@PathVariable(value="id") int id) {
		return imageService.deleteImage(id);
	}

}
