package com.example.mountainclimbing.security;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import com.example.mountainclimbing.model.User;
import com.example.mountainclimbing.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AuthenticationFilter extends AbstractAuthenticationProcessingFilter{

	@Autowired
	private UserRepository userRepository;

	protected AuthenticationFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager) {
		super(defaultFilterProcessesUrl, authenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		User data = new ObjectMapper().readValue(request.getInputStream(), User.class);
		if(userRepository.findUserByUsername(data.getUsername()).isPresent()) {
			UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(data.getUsername(), data.getPassword());
			Authentication authentication = getAuthenticationManager().authenticate(authReq);
			return authentication;
		} else {
			throw new AccessDeniedException("User not found with specific username!");
		}
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		SecurityContextHolder.getContext().setAuthentication(authResult);
		chain.doFilter(request, response);
	}
	
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		log.info("Unsuccessful authentication");
		super.unsuccessfulAuthentication(request, response, failed);
	}

}
