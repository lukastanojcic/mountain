package com.example.mountainclimbing.service;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.mountainclimbing.dto.ImageDto;
import com.example.mountainclimbing.mapper.ImageMapper;
import com.example.mountainclimbing.model.Image;
import com.example.mountainclimbing.repository.ImageRepository;


@Service
public class ImageService {
	
	private static final String BASE_URI = "C:/sviluppo/spool/saluber/test1/";
	
	private final ImageRepository imageRepository;
	private final ImageMapper imageMapper;
	
	public ImageService(ImageRepository imageRepository, ImageMapper imageMapper) {
		this.imageRepository = imageRepository;
		this.imageMapper = imageMapper;
	}

	public Optional<ImageDto> createImage(Integer albumId, MultipartFile multipartFile) {
		final Image image = new Image(null, multipartFile.getOriginalFilename(), multipartFile.getSize(), multipartFile.getContentType(), LocalDateTime.now(), albumId, null);
		try(BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(Files.newOutputStream(Paths.get(BASE_URI + multipartFile.getOriginalFilename())))){
			bufferedOutputStream.write(multipartFile.getBytes());
		}
		catch (IOException e) {
			e.printStackTrace();
			//handle exception and return something else
			// TODO: handle exception
		}
		return Optional.of(this.imageMapper.entityToDto(imageRepository.save(image)));
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
	
	private byte [] getImageBytes (String name) {
		byte [] data = new byte[1024];
		try (BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(Paths.get(BASE_URI + name)))){
			bufferedInputStream.read(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public List<ImageDto> findAll () {
		final List<ImageDto> LIST_IMAGES = StreamSupport.stream(this.imageRepository.findAll().spliterator(), false)
			.map(new Function<Image, ImageDto>() {

				@Override
				public ImageDto apply(Image value) {
					// TODO Auto-generated method stub
					byte [] bufferArray = getImageBytes(value.getName());
					value.setBufferArray(bufferArray);
					return imageMapper.entityToDto(value);
				}
			})
			.collect(Collectors.toList());
		return LIST_IMAGES;
	}
	
	//rewrite update image method
	public Optional<ImageDto> updateImage(Integer id, ImageDto imageDto) {
		if(imageRepository.existsById(id)) {
			Image update = this.imageMapper.dtoToEntity(imageDto); 
			return Optional.ofNullable(this.imageMapper.entityToDto(imageRepository.save(update)));
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

	public List<ImageDto> getThreeRandomImages() {
		List<ImageDto> all = findAll();
		List<ImageDto> three = new ArrayList<ImageDto>();
		Random rand = new Random();
		int counter = 0;
		while(counter < 3) {
			ImageDto randomImage = all.get(rand.nextInt(all.size())); 
			if(!three.contains(randomImage)) {
				three.add(randomImage);
				counter++;
			}
		}
		return three;
	}

}
