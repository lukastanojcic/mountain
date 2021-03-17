package com.example.mountainclimbing.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public Image createImage(@RequestBody Image image, HttpServletRequest  req, HttpServletResponse res) {
		return imageService.createImage(image,req,res);
	}
	
	@GetMapping("/{id}")
	public Optional<Image> readImage(@PathVariable(value="id") int id, HttpServletRequest  req, HttpServletResponse res) {
		return imageService.readImage(id,req,res);
	}
	
	@PutMapping("/{id}")
	public Image updateImage(@PathVariable(value="id") int id,@RequestBody Image image, HttpServletRequest  req, HttpServletResponse res) throws Exception {
		return imageService.updateImage(id, image,req,res);
	}
	
	@DeleteMapping("/{id}")
	public void deleteImage(@PathVariable(value="id") int id, HttpServletRequest  req, HttpServletResponse res) {
		imageService.deleteImage(id,req,res);
	}

}
