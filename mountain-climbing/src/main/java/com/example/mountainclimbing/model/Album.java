package com.example.mountainclimbing.model;

import java.time.LocalDateTime;
import java.util.Set;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Table(value = "album")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Album {

	@Id
	@NotNull
	private Integer id;
	private String name;
	private String description;
	@NotNull
	private LocalDateTime creationDate;
	private Integer coverId;
	
	@MappedCollection(keyColumn = "albumId", idColumn = "id")
	private Set<Image> images;
	
}
