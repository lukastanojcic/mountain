package com.example.mountainclimbing.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
public class DbCustomConfiguration {

	@Bean
	@Profile("test-db")
	public DataSource dataSource(ConfigProperties mySqlConfig) {
		return DataSourceBuilder
				.create()
				.driverClassName(mySqlConfig.getDriverClassName())
				.url(mySqlConfig.url)
				.username(mySqlConfig.getUsername())
				.password(mySqlConfig.getPassword())
				.build();
	}

	@Bean
	@Profile("hikari-db")
	public HikariDataSource hikariDataSource () {
		return null;
	}

	@ConfigurationProperties(prefix="mysql")
	@Getter @Setter
	public static class ConfigProperties {
		
		/**
		 * Name of the database driver
		 */
		private String driverClassName;
		/**
		 * URL for database
		 */
		private String url;//URL for database
		/**
		 * Username for the connection to database
		 */
		private String username;
		/**
		 * Password for the connection to database
		 */
		private String password;

	}

}
