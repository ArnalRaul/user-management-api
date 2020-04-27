package com.usermanagement.request;

import lombok.Getter;
import lombok.Setter;


 public class SignUpRequest {
	@Setter
	@Getter
	private String userId , password, email , name ,surname;

	public SignUpRequest(String userId, String password, String email, String name, String surname) {
		super();
		this.userId = userId;
		this.password = password;
		this.email = email;
		this.name = name;
		this.surname = surname;
	}
	
	
}
