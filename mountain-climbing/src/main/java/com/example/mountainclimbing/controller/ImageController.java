package com.example.mountainclimbing.controller;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.mountainclimbing.model.Image;
import com.example.mountainclimbing.service.ImageService;

@RestController
@RequestMapping("/image")
public class ImageController {
	
	private final ImageService imageService;
	
	public ImageController(ImageService imageService) {
		this.imageService = imageService;
	}
	
	@GetMapping
	public ResponseEntity<List<Image>> findAll (){
		final List<Image> DATA = this.imageService.findAll();
		if(DATA.size() > 0) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(DATA);
		}
		else {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.build();
		}
	}
	
	@PostMapping("/{albumId}")
	public  ResponseEntity<Image> createImage(@PathVariable Integer albumId, @RequestParam("files") MultipartFile multipartFile) {		
		Image data = imageService.createImage(albumId, multipartFile);
		if(data != null) {
			return new ResponseEntity<Image>(data,HttpStatus.CREATED);	
		}
		else {
			return new ResponseEntity<Image>(HttpStatus.NO_CONTENT );
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> readImage(@PathVariable Integer id) {
		Map<String,Object> data = imageService.readImage(id);
		if(!data.isEmpty()) {
			return new ResponseEntity<Map<String,Object>>(data, HttpStatus.OK);
		}
		return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
		
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
