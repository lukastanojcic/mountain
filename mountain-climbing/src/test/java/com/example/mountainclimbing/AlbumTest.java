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
		image1.setSize(100);
		
		Image image2 = new Image();
		image2.setId(null);
		image2.setAlbumId(17);
		image2.setInsertDate(LocalDateTime.now());
		image2.setContentType("type");
		image2.setName("Image2");
		image2.setSize(100);
		
		Set<Image> setImages = new HashSet<>();
		setImages.add(image1);
		setImages.add(image2);
		
		/*Album album = new Album(null, "album1", "Album 1", LocalDateTime.now(), 1, setImages);
		
		Album data = this.albumService.createAlbum(album);
		assertNotNull(data, "Data is not added in database");*/
		
		/*Optional<Album> opt = albumService.readAlbum(16);
		Album album1 = opt.get();
		System.out.println("ALBUM: " + album1.getName());*/
		
		/*Album album2 = new Album(16, "album2", "Album 2", LocalDateTime.now(), 1, setImages);
		
		Album album3 = albumService.updateAlbum(16, album2);
		System.out.println("UPDATE-OVANI ALBUM: " + album3.getName());*/
		
		boolean znak = albumService.deleteAlbum(17);
		if(znak) {
			System.out.println("USPESNO BRISANJE");
		}else {
			System.out.println("NEUSPESNO BRISANJE");
		}
	}
	
	
	
}
