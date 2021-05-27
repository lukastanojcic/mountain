package com.example.mountainclimbing.model;

import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mail {
	@Id
	@NotNull
	private Integer id;
	private String sendTo;
	private String subject;
	private String message;
	private String pathToAttachment;
}
