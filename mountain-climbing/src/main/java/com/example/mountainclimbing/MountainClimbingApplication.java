package com.example.mountainclimbing;

import com.example.mountainclimbing.config.DbCustomConfiguration;
import java.util.Properties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableConfigurationProperties(DbCustomConfiguration.ConfigProperties.class)
@EnableAspectJAutoProxy
public class MountainClimbingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MountainClimbingApplication.class, args);
	}
	
//	public class MailSender {
//		@Bean
//		public JavaMailSender getJavaMailSender() {
//			JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//			mailSender.setHost("smtp.gmail.com");
//			mailSender.setPort(587);
//			mailSender.setUsername("lukastanojcic@gmail.com");
//			mailSender.setPassword("Retrovizor.1");
//			
//			Properties props = mailSender.getJavaMailProperties();
//			props.put("mail.transport.protocol", "smtp");
//		    props.put("mail.smtp.auth", "true");
//		    props.put("mail.smtp.starttls.enable", "true");
//		    props.put("mail.debug", "true");
//		    
//		    return mailSender;
//		}
//	}
}
