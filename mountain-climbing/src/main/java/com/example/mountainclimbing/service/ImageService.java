package com.example.mountainclimbing.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mountainclimbing.model.Image;
import com.example.mountainclimbing.repository.ImageRepository;


@Service
public class ImageService {
	
	@Autowired
	private ImageRepository imageRepository;
	
	public Image createImage(Image image) {
		imageRepository.save(image);
		return image;
	}
	
	public Optional<Image> readImage(int id) {
		return imageRepository.findById(id);
	}
	
	
	public Image updateImage(int id,Image image) throws Exception {
		if(imageRepository.existsById(id)) {
			imageRepository.save(image);
			return image;
		}
		throw new Exception("Not found.");
	}
	
	
	public void deleteImage(@RequestParam int id) {
		imageRepository.deleteById(id);
	}

}
