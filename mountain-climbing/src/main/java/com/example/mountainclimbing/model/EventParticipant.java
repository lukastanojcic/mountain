package com.example.mountainclimbing.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Table(value = "participants")
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
public class EventParticipant {

	@Id
	@NotNull
	private int id;
	@NotNull
	private int eventId;
	private String name;
	private String contact;
}
