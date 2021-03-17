package com.example.mountainclimbing.service;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

	public Image createImage(Image image, HttpServletRequest req, HttpServletResponse res) {
		imageRepository.save(image);
		return image;
	}
	
	public Optional<Image> readImage(int id, HttpServletRequest req, HttpServletResponse res) {
		return imageRepository.findById(id);
	}
	
	
	public Image updateImage(int id,Image image, HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(imageRepository.existsById(id)) {
			imageRepository.save(image);
			return image;
		}
		throw new Exception("Not found.");
	}
	
	
	public void deleteImage(@RequestParam int id, HttpServletRequest req, HttpServletResponse res) {
		imageRepository.deleteById(id);
	}

}
