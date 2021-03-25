package com.example.mountainclimbing.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Table(value = "images")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Image {

	@Id
	private Integer id;
	private String name;
	private Long size;
	private String contentType;
	private LocalDateTime insertDate;
	private Integer albumId;

}
