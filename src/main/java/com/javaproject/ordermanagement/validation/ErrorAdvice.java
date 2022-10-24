package com.javaproject.ordermanagement.validation;

public class ErrorAdvice extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ErrorAdvice(String msg) {
		super(msg);
	}
	
	public ErrorAdvice(String msg, Throwable cause) {
		super(msg, cause);
	}

}
