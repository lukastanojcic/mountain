package com.example.mountainclimbing.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mountainclimbing.model.Image;
import com.example.mountainclimbing.service.ImageService;

@RestController
@RequestMapping("/image")
public class ImageController {
	
	private final ImageService imageService;
	
	public ImageController(ImageService imageService) {
		// TODO Auto-generated constructor stub
		this.imageService = imageService;
	}
	
	@PostMapping
	@ResponseBody
	public Image createImage(@RequestBody Image image) {
		return imageService.createImage(image);
	}
	
	@GetMapping
	@ResponseBody
	public Optional<Image> readImage(@RequestParam int id) {
		return imageService.readImage(id);
	}
	
	@PutMapping
	@ResponseBody
	public Image updateImage(@RequestParam int id,@RequestBody Image image) throws Exception {
		return imageService.updateImage(id, image);
	}
	
	@DeleteMapping
	@ResponseBody
	public void deleteImage(@RequestParam int id) {
		imageService.deleteImage(id);
	}

}
