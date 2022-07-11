package com.javaproject.ordermanagement.validation;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.javaproject.ordermanagement.exception.ExceptionHandlerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
	
	@ExceptionHandler(ExceptionHandlerAdvice.class)
	public ResponseEntity<MessageExceptionHandler> productNotFound(ExceptionHandlerAdvice exception){
		MessageExceptionHandler error = new MessageExceptionHandler(new Date(), HttpStatus.NOT_FOUND.value(), "Client not found");
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}
}
