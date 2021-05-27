package com.example.mountainclimbing.dto;

import lombok.Data;

@Data
public class UserDto {
	
	private Integer id;
	private String username;
	private String password;
	private String name;
	private String surname;
	private String email;
	private String city;
	private String address;
	private String pictureUrl;
	private Integer gender;
	private String birthdate;
	private Integer postalCode;
}
