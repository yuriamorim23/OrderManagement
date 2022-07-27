package com.javaproject.ordermanagement.validation;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.javaproject.ordermanagement.exception.ExceptionHandlerAdvice;
import com.javaproject.ordermanagement.exception.MinPriceValidation;
import com.javaproject.ordermanagement.exception.ProductNotFound;

@RestControllerAdvice
public class ControllerAdvice {
	
	@ExceptionHandler(ExceptionHandlerAdvice.class)
	public ResponseEntity<MessageExceptionHandler> productNotFound(ExceptionHandlerAdvice exception){
		MessageExceptionHandler error = new MessageExceptionHandler(new Date(), HttpStatus.NOT_FOUND.value(), "Client not found");
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(MinPriceValidation.class)
	public ResponseEntity<MessageExceptionHandler> priceValidation(MinPriceValidation exception){
		MessageExceptionHandler error = new MessageExceptionHandler(new Date(), HttpStatus.BAD_REQUEST.value(), "The minPrice must be lower than the Price!");
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(ProductNotFound.class)
	public ResponseEntity<MessageExceptionHandler> findProductById(ProductNotFound exception){
		MessageExceptionHandler error = new MessageExceptionHandler(new Date(), HttpStatus.NOT_FOUND.value(), "Product not found!");
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}
}
