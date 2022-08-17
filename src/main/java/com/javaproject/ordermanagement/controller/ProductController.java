package com.javaproject.ordermanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.javaproject.ordermanagement.dto.GetProductQueryResult;
import com.javaproject.ordermanagement.dto.CreateProductCommand;
import com.javaproject.ordermanagement.dto.UpdateProductCommand;

public interface ProductController {

	ResponseEntity<List<GetProductQueryResult>> findAll();

	ResponseEntity<GetProductQueryResult> findById(@PathVariable("id") Long id);
	
	ResponseEntity<GetProductQueryResult> productRegister(@RequestBody @Valid CreateProductCommand createProductCommand);
	
	GetProductQueryResult updateById(@RequestBody UpdateProductCommand updateProductCommand, @PathVariable("id") Long id);
	
	void deleteById(@PathVariable("id") Long id);

}
