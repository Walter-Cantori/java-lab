package com.shoppingList.resources.exceptions;


public class ResourceError {
	private String error;
	private Long timestamp;
	
	public ResourceError() {
		super();
	}
	
	public ResourceError(String error, Long timestamp) {
		super();
		this.error = error;
		this.timestamp = timestamp;
	}
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
