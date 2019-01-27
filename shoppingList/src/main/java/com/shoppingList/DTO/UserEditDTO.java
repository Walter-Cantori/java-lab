package com.shoppingList.DTO;

import java.io.Serializable;

import javax.validation.constraints.Email;

public class UserEditDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	@Email(message="Invalid Email")
	private String email;
	private String password;
	private String oldPassword;
	
	public UserEditDTO() {
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getOldPassword() {
		return oldPassword;
	}


	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

}
