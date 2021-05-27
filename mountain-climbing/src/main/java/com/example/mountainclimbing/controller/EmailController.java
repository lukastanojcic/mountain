package com.example.mountainclimbing.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.mountainclimbing.model.Mail;
import com.example.mountainclimbing.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
	
	private final EmailService emailService;

	public EmailController(EmailService emailService) {
		this.emailService = emailService;
	}
	@PostMapping
	public ResponseEntity<Void> sendEmail(@RequestBody Mail mail) {
		emailService.sendEmail(mail);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
