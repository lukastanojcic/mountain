package com.example.mountainclimbing.mapper;

import org.mapstruct.Mapper;
import com.example.mountainclimbing.dto.ImageDto;
import com.example.mountainclimbing.model.Image;

@Mapper(componentModel = "spring")
public interface ImageMapper {
	
	Image dtoToEntity(ImageDto iamgeDto);
	ImageDto entityToDto(Image image);

}