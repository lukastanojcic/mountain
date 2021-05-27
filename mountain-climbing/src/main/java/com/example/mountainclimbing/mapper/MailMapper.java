package com.example.mountainclimbing.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import com.example.mountainclimbing.dto.MailDto;
import com.example.mountainclimbing.model.Mail;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MailMapper {

	Mail dtoToEntity(MailDto mailDto);
	MailDto entityToDto(Mail mail);
}
