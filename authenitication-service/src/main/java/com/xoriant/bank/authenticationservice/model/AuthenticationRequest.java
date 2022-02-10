package com.xoriant.bank.authenticationservice.model;

import java.io.Serializable;

public class AuthenticationRequest implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;

	public String getUsername() {
		return userName;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// need default constructor for JSON Parsing
	public AuthenticationRequest(String userName, String password) {
		this.setUsername(userName);
		this.setPassword(password);
	}
}