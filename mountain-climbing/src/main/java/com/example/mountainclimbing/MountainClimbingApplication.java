package com.example.mountainclimbing;

import com.example.mountainclimbing.config.DbCustomConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(DbCustomConfiguration.ConfigProperties.class)
public class MountainClimbingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MountainClimbingApplication.class, args);
	}
}
