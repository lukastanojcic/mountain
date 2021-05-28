package com.example.mountainclimbing.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/user").permitAll()
			.antMatchers(HttpMethod.GET, "/user/getAllUsers").permitAll()
			.antMatchers(HttpMethod.GET, "/user/getUser/2").permitAll()
			.antMatchers(HttpMethod.POST, "/email").permitAll()
			.antMatchers(HttpMethod.GET, "/image/three").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.permitAll()
				.and()
			.logout();
				
	}
	
	@Bean
	public PasswordEncoder passwordEncoder () {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}