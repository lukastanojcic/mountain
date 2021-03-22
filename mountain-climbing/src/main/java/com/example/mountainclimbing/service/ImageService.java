package com.example.mountainclimbing.service;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.mountainclimbing.model.Image;
import com.example.mountainclimbing.repository.ImageRepository;


@Service
public class ImageService {
	
	private final ImageRepository imageRepository;
	
	public ImageService(ImageRepository imageRepository) {
		this.imageRepository = imageRepository;
	}

	public ResponseEntity<Image> createImage(Image image,BindingResult result) {
		if(result.hasErrors()) {
			return new ResponseEntity<Image>(HttpStatus.BAD_REQUEST);
		}
		imageRepository.save(image);
		return new ResponseEntity<Image>(image,HttpStatus.CREATED);
	}
	
	public ResponseEntity<Image> readImage(int id) {
		Optional<Image> opt =  imageRepository.findById(id);
		if(opt.isPresent()) {
			return new ResponseEntity<Image>(opt.get(),HttpStatus.OK);
		}
		return new ResponseEntity<Image>(opt.get(),HttpStatus.NOT_FOUND);
	}
	
	
	public ResponseEntity<Image> updateImage(int id,Image image,BindingResult result) {
		if(result.hasErrors()) {
			return new ResponseEntity<Image>(HttpStatus.BAD_REQUEST);
		}
		if(imageRepository.existsById(id)) {
			imageRepository.save(image);
			return new ResponseEntity<Image>(image,HttpStatus.OK);
		}
		return new ResponseEntity<Image>(image,HttpStatus.NOT_FOUND);
		
	}
	
	
	public ResponseEntity<Void> deleteImage(@RequestParam int id) {
		if(imageRepository.existsById(id)) {
		imageRepository.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
