package com.javaproject.ordermanagement.service;

import java.util.List;

import com.javaproject.ordermanagement.dto.ProductDTO;
import com.javaproject.ordermanagement.dto.ProductSubmit;
import com.javaproject.ordermanagement.dto.ProductUpdate;

public interface ProductService {

	List<ProductDTO> findAll();

	ProductDTO findById(Long id);

	ProductDTO createProductCommand(ProductSubmit submit);

	ProductDTO UpdateProductCommand(ProductUpdate update, Long Id);

	void deleteById(Long id);

}
