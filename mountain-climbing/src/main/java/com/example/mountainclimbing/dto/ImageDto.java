package com.example.mountainclimbing.dto;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageDto {

	private Integer id;
	private String name;
	private Long size;
	private String contentType;
	private LocalDateTime insertDate;
	private Integer albumId;
	private byte [] bufferArray;
}
