package com.example.mountainclimbing.service;

import java.io.IOException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.mountainclimbing.mapper.MailMapper;
import com.example.mountainclimbing.model.Mail;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender emailSender;
	private MailMapper mailMapper;
	
	public EmailService(MailMapper mailMapper) {
		this.mailMapper = mailMapper;
	}
	
	
	public void sendEmail(Mail mail) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(mail.getSendTo());
		msg.setSubject(mail.getSubject());
		msg.setText(mail.getMessage());
		emailSender.send(msg);
	}
	
	public void sendEmailWithAttachement(Mail mail) throws MessagingException, IOException {
		MimeMessage msg = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setTo(mail.getSendTo());
		helper.setSubject(mail.getSubject());
		helper.setText(mail.getMessage());
		helper.addAttachment("my_photo.png", new ClassPathResource("android.ong"));
		emailSender.send(msg);
	}
	
}
