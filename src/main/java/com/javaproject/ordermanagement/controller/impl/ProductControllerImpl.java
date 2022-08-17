package com.javaproject.ordermanagement.controller.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaproject.ordermanagement.controller.ProductController;
import com.javaproject.ordermanagement.dto.GetProductQueryResult;
import com.javaproject.ordermanagement.dto.CreateProductCommand;
import com.javaproject.ordermanagement.dto.UpdateProductCommand;
import com.javaproject.ordermanagement.service.ProductService;

@RestController
@RequestMapping(value = "api/v1/product")
public class ProductControllerImpl implements ProductController {
	
	@Autowired
	private ProductService service;

	@GetMapping
	public ResponseEntity<List<GetProductQueryResult>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}


	@GetMapping("/{id}")
	public ResponseEntity<GetProductQueryResult> findById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<GetProductQueryResult> productCreate(@RequestBody @Valid CreateProductCommand createProductCommand) {
		return new ResponseEntity<>(service.createProduct(createProductCommand), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<GetProductQueryResult> productUpdate(@RequestBody @Valid UpdateProductCommand updateProductCommand, @PathVariable("id") Long id) {
		return new ResponseEntity<>(service.updateProduct(updateProductCommand, id), HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		service.deleteById(id);
	}	
}
