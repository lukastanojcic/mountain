package com.example.mountainclimbing.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import com.example.mountainclimbing.dto.AlbumDto;
import com.example.mountainclimbing.model.Album;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AlbumMapper {
	
	Album dtoToEntity(AlbumDto albumDto);
	AlbumDto entityToDto(Album album);

}
