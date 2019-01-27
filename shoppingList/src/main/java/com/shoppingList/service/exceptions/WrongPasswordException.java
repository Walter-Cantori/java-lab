package com.shoppingList.service.exceptions;

public class WrongPasswordException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public WrongPasswordException() {
		super();
	}
	
	public WrongPasswordException(String msg) {
		super(msg);
	}
	
}
