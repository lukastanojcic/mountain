package com.example.mountainclimbing.dto;

import java.time.LocalDateTime;
import java.util.Set;
import com.example.mountainclimbing.model.Image;
import lombok.Data;

@Data
public class AlbumDto {

	private Integer id;
	private String name;
	private String description;
	private LocalDateTime creationDate;
	private Integer coverId;
	private Set<Image> images;
}
