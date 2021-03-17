package com.example.mountainclimbing.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public  ResponseEntity<Image> createImage(@Valid @RequestBody Image image, HttpServletRequest  req, HttpServletResponse res) {
		return imageService.createImage(image,req,res);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Image> readImage(@PathVariable(value="id") int id, HttpServletRequest  req, HttpServletResponse res) {
		Optional<Image> opt = imageService.readImage(id,req,res);
		if(opt.isPresent()) {
			return new ResponseEntity<Image>(opt.get(),HttpStatus.OK);
		}
		return new ResponseEntity<Image>(opt.get(),HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Image> updateImage(@PathVariable(value="id") int id,@Valid @RequestBody Image image, HttpServletRequest  req, HttpServletResponse res){
		return imageService.updateImage(id, image,req,res);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteImage(@PathVariable(value="id") int id, HttpServletRequest  req, HttpServletResponse res) {
		return imageService.deleteImage(id,req,res);
	}

}
