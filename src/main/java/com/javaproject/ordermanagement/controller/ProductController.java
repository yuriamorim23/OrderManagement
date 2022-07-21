package com.javaproject.ordermanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.javaproject.ordermanagement.dto.ProductDTO;
import com.javaproject.ordermanagement.dto.ProductSubmit;
import com.javaproject.ordermanagement.dto.ProductUpdate;

public interface ProductController {

	ResponseEntity<List<ProductDTO>> findAll();

	ResponseEntity<ProductDTO> findById(@PathVariable("id") Long id);
	
	ResponseEntity<ProductDTO> productRegister(@RequestBody @Valid ProductSubmit submit);
	
	ProductDTO updateById(@RequestBody ProductUpdate update, @PathVariable("id") Long id);
	
	void deleteById(@PathVariable("id") Long id);

}
