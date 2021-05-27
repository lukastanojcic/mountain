package com.example.mountainclimbing.dto;

import lombok.Data;

@Data
public class MailDto {

	private Integer id;
	private String sendTo;
	private String subject;
	private String message;
	private String pathToAttachment;
}
