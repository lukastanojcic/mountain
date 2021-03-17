package com.example.mountainclimbing.service;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.mountainclimbing.model.Image;
import com.example.mountainclimbing.repository.ImageRepository;


@Service
public class ImageService {
	
	private final ImageRepository imageRepository;
	
	public ImageService(ImageRepository imageRepository) {
		this.imageRepository = imageRepository;
	}

	public ResponseEntity<Image> createImage(Image image, HttpServletRequest req, HttpServletResponse res) {
		imageRepository.save(image);
		return new ResponseEntity<Image>(image,HttpStatus.OK);
	}
	
	public Optional<Image> readImage(int id, HttpServletRequest req, HttpServletResponse res) {
		return imageRepository.findById(id);
	}
	
	
	public ResponseEntity<Image> updateImage(int id,Image image, HttpServletRequest req, HttpServletResponse res) {
		if(imageRepository.existsById(id)) {
			imageRepository.save(image);
			return new ResponseEntity<Image>(image,HttpStatus.OK);
		}
		return new ResponseEntity<Image>(image,HttpStatus.NOT_FOUND);
		
	}
	
	
	public ResponseEntity<Void> deleteImage(@RequestParam int id, HttpServletRequest req, HttpServletResponse res) {
		if(imageRepository.existsById(id)) {
		imageRepository.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
