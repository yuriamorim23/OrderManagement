package com.javaproject.ordermanagement.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaproject.ordermanagement.dto.GetProductQueryResult;
import com.javaproject.ordermanagement.dto.CreateProductCommand;
import com.javaproject.ordermanagement.dto.UpdateProductCommand;
import com.javaproject.ordermanagement.entities.Product;
import com.javaproject.ordermanagement.exception.MinPriceValidation;
import com.javaproject.ordermanagement.exception.ProductNotFound;
import com.javaproject.ordermanagement.repositories.ProductRepository;
import com.javaproject.ordermanagement.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<GetProductQueryResult> findAll(){
		List<Product> all = repository.findAll();
		return convertListToDto(all);
	}
	
	private static List<GetProductQueryResult> convertListToDto(List<Product> products){
		return products.stream().map(GetProductQueryResult::new).collect(Collectors.toList());
	}

	@Transactional
	public GetProductQueryResult findById(Long id) {
		Optional<Product> optional = repository.findById(id);
		if(optional.isPresent()) {
			return convertToDto(optional.get());
		}
		throw new ProductNotFound();
	}

	@Transactional
	public GetProductQueryResult createProductCommand(CreateProductCommand submit) {
		Product product = convertToBusiness(submit);
		if(submit.getMinPrince() > submit.getPrice()) {
			throw new MinPriceValidation();
		}else {
			product = repository.save(product);
		}
		return convertToDto(product);
	}

	@Transactional
	public GetProductQueryResult UpdateProductCommand(UpdateProductCommand update, Long Id) {
		Optional<Product> op = repository.findById(Id);
		if(op.isPresent()) {
			Product obj = op.get();
			if(update.getDescription() != null 
					&& update.getMinPrince() != null 
					&& update.getPrice() != null
					&& update.getStockQuantity() != null) {
				if(update.getMinPrince() > update.getPrice()) {
					throw new MinPriceValidation();
				}
				obj.setDescription(update.getDescription());
				obj.setMinPrince(update.getMinPrince());
				obj.setPrice(update.getPrice());
				obj.setStockQuantity(update.getStockQuantity());
			}
			repository.save(obj);
			return convertToDto(obj);
		}
		return null;
	}

	@Transactional
	public void deleteById(Long id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
		}else {
			throw new ProductNotFound();
		}
	}
	
	public Product convertToBusiness(CreateProductCommand submit) {
		Product product = new Product();
		product.setCode(submit.getCode());
		product.setDescription(submit.getDescription());
		product.setPrice(submit.getPrice());
		product.setMinPrince(submit.getMinPrince());
		product.setStockQuantity(submit.getStockQuantity());
		return product;
	}
	
	public GetProductQueryResult convertToDto(Product product) {
		GetProductQueryResult dto = new GetProductQueryResult();
		dto.setId(product.getId());
		dto.setCode(product.getCode());
		dto.setDescription(product.getDescription());
		dto.setPrice(product.getPrice());
		dto.setMinPrince(product.getMinPrince());
		dto.setStockQuantity(product.getStockQuantity());
		return dto;
	}
}
