package com.tutorial.app.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailRequestModel {
	@NotNull(message="First name cannot be null")
	private String firstName;
	
	@NotNull(message="Last name cannot be null")
	private String lastName;
	
	@NotNull(message="Email name cannot be null")
	@Email
	private String email;
	
	@NotNull(message="Password name cannot be null")
	@Size(min=8, max=16, message="Password must have 8 to 16 chars")
	private String password;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
}
