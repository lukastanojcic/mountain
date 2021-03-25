package com.example.mountainclimbing.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Table(value = "images")
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
public class Image {

	@Id
	@NotNull
	private int id;
	private String name;
	private int size;
	@NotNull
	private String contentType;
	@NotNull
	private LocalDateTime insertDate;
	private int albumId;

}
