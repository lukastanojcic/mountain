package com.example.mountainclimbing.service;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.mountainclimbing.model.Image;
import com.example.mountainclimbing.repository.ImageRepository;


@Service
public class ImageService {
	
	private final ImageRepository imageRepository;
	
	public ImageService(ImageRepository imageRepository) {
		this.imageRepository = imageRepository;
	}

	public Image createImage(Image image) {
		return 	imageRepository.save(image);
	}
	
	public Optional<Image> readImage(Integer id) {
		return  imageRepository.findById(id);
	}
	
	
	public Optional<Image> updateImage(Integer id,Image image) {
		if(imageRepository.existsById(id)) {
			return Optional.ofNullable(imageRepository.save(image));
		}
		return Optional.empty();
	}
	
	
	public boolean deleteImage(Integer id) {
		if(imageRepository.existsById(id)) {
			imageRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
