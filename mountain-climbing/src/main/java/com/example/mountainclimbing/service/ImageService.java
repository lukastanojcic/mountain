package com.example.mountainclimbing.service;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.mountainclimbing.model.Image;
import com.example.mountainclimbing.repository.ImageRepository;


@Service
public class ImageService {
	
	private static final String BASE_URI = "C:/sviluppo/spool/saluber/test1/";
	
	private final ImageRepository imageRepository;
	
	public ImageService(ImageRepository imageRepository) {
		this.imageRepository = imageRepository;
	}

	public Image createImage(Integer albumId, MultipartFile multipartFile) {
		final Image image = new Image(null, multipartFile.getOriginalFilename(), multipartFile.getSize(), multipartFile.getContentType(), LocalDateTime.now(), albumId);
		try(BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(Files.newOutputStream(Paths.get(BASE_URI + multipartFile.getOriginalFilename())))){
			bufferedOutputStream.write(multipartFile.getBytes());
		}
		catch (IOException e) {
			e.printStackTrace();
			//handle exception and return something else
			// TODO: handle exception
		}
		return 	imageRepository.save(image);
	}
	
	public Map<String, Object> readImage(Integer id) {
		final Map<String, Object> map = new HashMap<>();
		Optional<Image> optional = imageRepository.findById(id);
		optional.ifPresent(item-> {
			try (BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(Paths.get(BASE_URI + item.getName())))){
				byte [] data = new byte[1024];
				bufferedInputStream.read(data);
				map.put("value", data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		return map;
	}
	
	//rewrite update image method
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
