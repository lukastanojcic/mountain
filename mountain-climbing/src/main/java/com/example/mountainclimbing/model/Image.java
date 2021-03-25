package com.example.mountainclimbing.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Table(value = "images")
@Getter
@Setter
public class Image {

	@Id
	@NotNull
	private Integer id;
	private String name;
	private int size;
	@NotNull
	private String contentType;
	@NotNull
	private LocalDateTime insertDate;
	private int albumId;

}
