package com.javaproject.ordermanagement.service;

import java.util.List;

import com.javaproject.ordermanagement.dto.GetProductQueryResult;
import com.javaproject.ordermanagement.dto.CreateProductCommand;
import com.javaproject.ordermanagement.dto.UpdateProductCommand;

public interface ProductService {

	List<GetProductQueryResult> findAll();

	GetProductQueryResult findById(Long id);

	GetProductQueryResult createProduct(CreateProductCommand createProductCommand);

	GetProductQueryResult updateProduct(UpdateProductCommand cpdateProductCommand, Long Id);

	void deleteById(Long id);

}
