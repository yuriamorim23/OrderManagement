package com.javaproject.ordermanagement.Exceptions;

public class DefaultExceptions extends RuntimeException {
	private static final long serialVersionUID = 1L;

	
	public DefaultExceptions(String msg) {
		super(msg);
	}

	public DefaultExceptions(String msg, Throwable cause) {
		super(msg, cause);
	}

}