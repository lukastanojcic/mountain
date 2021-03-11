package com.example.mountainclimbing.config;

import com.example.mountainclimbing.MountainClimbingApplication;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DbCustomConfiguration {

	@Bean
	@Profile("test-db")
	public DataSource dataSource(ConfigProperties mySqlConfig) {
		return DataSourceBuilder
				.create()
				.driverClassName(mySqlConfig.getDriverClassName())
				.password(mySqlConfig.getPassword())
				.username(mySqlConfig.getUsername())
				.url(mySqlConfig.getUrl())
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

		private String driverClassName;
		private String password;
		private String username;
		private String url;

		public String getDriverClassName() {
			return driverClassName;
		}
		public void setDriverClassName(String driverClassName) {
			this.driverClassName=driverClassName;
		}

	}

}
