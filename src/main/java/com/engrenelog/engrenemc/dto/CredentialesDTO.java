package com.engrenelog.engrenemc.dto;

import java.io.Serializable;

public class CredentialesDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String email;
	private String password;
	
	
	public CredentialesDTO() {
		
	}


	public CredentialesDTO(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setUsername(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}
