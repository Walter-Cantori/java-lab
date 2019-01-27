package com.shoppingList.resources.exceptions;

import java.util.List;

public class ValidationError extends ResourceError{

	private List<FieldMessages> errors;
	
	public ValidationError() {
		
	}
	
	public ValidationError(String error, Long timestamp) {
		super(error, timestamp);
	}

	public List<FieldMessages> getErrors() {
		return errors;
	}

	public void addErrors(String field, String message) {
		errors.add(new FieldMessages(field, message));
	}
	
	
}
