package com.example.mountainclimbing.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Table(value = "events")
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
public class Event {

	@Id
	@NotNull
	private int id;
	private String name;
	private String info;
	@NotNull
	private LocalDateTime insertDate;
	@NotNull
	private String place;
	private int eventPictureId;
}
