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
@RequestMapping(value = "api/v1/")
public class ProductControllerImpl implements ProductController {
	
	@Autowired
	private ProductService service;

	@GetMapping("/product")
	public ResponseEntity<List<GetProductQueryResult>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}


	@GetMapping("product/{id}")
	public ResponseEntity<GetProductQueryResult> findById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}

	@PostMapping("/product")
	public ResponseEntity<GetProductQueryResult> productRegister(@RequestBody @Valid CreateProductCommand createProductCommand) {
		return new ResponseEntity<>(service.createProductCommand(createProductCommand), HttpStatus.CREATED);
	}

	@PutMapping("product/{id}")
	public GetProductQueryResult updateById(@RequestBody @Valid UpdateProductCommand updateProductCommand, @PathVariable("id") Long id) {
		return service.UpdateProductCommand(updateProductCommand, id);
	}

	@DeleteMapping("product/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		service.deleteById(id);
	}	
}
