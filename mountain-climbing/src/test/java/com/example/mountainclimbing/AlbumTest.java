package com.example.mountainclimbing;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mountainclimbing.model.Album;
import com.example.mountainclimbing.model.Image;
import com.example.mountainclimbing.service.AlbumService;

@SpringBootTest
public class AlbumTest {

	@Autowired
	private AlbumService albumService;
	
	@Test
	@DisplayName("One-to-Many Mapping Test")
	public void test () {
		
		Image image1 = new Image();
		image1.setId(null);
		image1.setAlbumId(17);
		image1.setInsertDate(LocalDateTime.now());
		image1.setContentType("type");
		image1.setName("Image1");
		image1.setSize(100L);
		
		Image image2 = new Image();
		image2.setId(null);
		image2.setAlbumId(17);
		image2.setInsertDate(LocalDateTime.now());
		image2.setContentType("type");
		image2.setName("Image2");
		image2.setSize(100L);
		
		Set<Image> setImages = new HashSet<>();
		setImages.add(image1);
		setImages.add(image2);
		
	}
	
	
	
}
