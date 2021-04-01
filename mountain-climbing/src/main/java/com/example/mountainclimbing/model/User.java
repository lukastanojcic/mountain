package com.example.mountainclimbing.model;

import java.util.Collection;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5093206695258782641L;
	@Id
	@NotNull
	private Integer id;
	private String username;
	private String password;
	private String name;
	private String lastname;
	private String email;
	private String city;
	private String address;
	private String pictureurl;
	private Integer gender;
	private String birthdate;
	private Integer postalCode;
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.createAuthorityList("ROLE_ADMIN");
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
