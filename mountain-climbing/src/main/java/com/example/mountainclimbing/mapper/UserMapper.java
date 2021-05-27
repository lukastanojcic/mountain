package com.example.mountainclimbing.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import com.example.mountainclimbing.dto.UserDto;
import com.example.mountainclimbing.model.User;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

	User dtoToEntity(UserDto userDto);
	UserDto entityToDto(User user);
}
