package com.javaproject.ordermanagement.service;

import java.util.List;

import com.javaproject.ordermanagement.dto.GetProductQueryResult;
import com.javaproject.ordermanagement.dto.CreateProductCommand;
import com.javaproject.ordermanagement.dto.UpdateProductCommand;

public interface ProductService {

	List<GetProductQueryResult> findAll();

	GetProductQueryResult findById(Long id);

	GetProductQueryResult createProductCommand(CreateProductCommand submit);

	GetProductQueryResult UpdateProductCommand(UpdateProductCommand update, Long Id);

	void deleteById(Long id);

}
