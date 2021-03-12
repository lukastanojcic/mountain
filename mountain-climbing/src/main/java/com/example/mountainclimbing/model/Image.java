package com.example.mountainclimbing.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Table(value = "images")
@Getter
@Setter
@RequiredArgsConstructor
public class Image {

	@Id
	private int id;
	private String name;
	private int size;
	private String contentType;
	private LocalDateTime insertDate;
	private int albumId;

}
