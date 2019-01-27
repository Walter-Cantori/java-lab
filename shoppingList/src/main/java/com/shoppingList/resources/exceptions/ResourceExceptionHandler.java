package com.shoppingList.resources.exceptions;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.shoppingList.service.exceptions.ResourceNotFoundException;
import com.shoppingList.service.exceptions.WrongPasswordException;

@ControllerAdvice
public class ResourceExceptionHandler {
	@ResponseBody
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResourceError userNotFoundExceptionHandler(ResourceNotFoundException ex) {
		ResourceError response = new ResourceError(ex.getMessage(), System.currentTimeMillis());
		return response;
	}
	
	@ResponseBody
	@ExceptionHandler(WrongPasswordException.class)
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	public ResourceError wrongPasswordExceptionHandler(WrongPasswordException ex) {
		ResourceError response = new ResourceError(ex.getMessage(), System.currentTimeMillis());
		return response;
	}
	
	@ResponseBody
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	public ResourceError methodArgumentNotValidException(MethodArgumentNotValidException ex) {
		ValidationError response = new ValidationError(ex.getMessage(), System.currentTimeMillis());
		
		for(FieldError error : ex.getBindingResult().getFieldErrors()) {
			response.addErrors(error.getField(), error.getDefaultMessage());
		}
		return response;
	}
	
	@ResponseBody
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	public ResourceError dataIntegrityViolationException(DataIntegrityViolationException ex) {
		ResourceError response = new ResourceError(ex.getMessage(), System.currentTimeMillis());
		return response;
	}
}
