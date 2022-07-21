package com.javaproject.ordermanagement.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaproject.ordermanagement.dto.ProductDTO;
import com.javaproject.ordermanagement.dto.ProductSubmit;
import com.javaproject.ordermanagement.dto.ProductUpdate;
import com.javaproject.ordermanagement.entities.Product;
import com.javaproject.ordermanagement.exception.ClientDeleted;
import com.javaproject.ordermanagement.exception.ExceptionHandlerAdvice;
import com.javaproject.ordermanagement.exception.MinPriceValidation;
import com.javaproject.ordermanagement.repositories.ProductRepository;
import com.javaproject.ordermanagement.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<ProductDTO> findAll(){
		List<Product> all = repository.findAll();
		return convertListToDto(all);
	}
	
	private static List<ProductDTO> convertListToDto(List<Product> products){
		return products.stream().map(ProductDTO::new).collect(Collectors.toList());
	}

	@Transactional
	public ProductDTO findById(Long id) {
		Optional<Product> optional = repository.findById(id);
		if(optional.isPresent()) {
			return convertToDto(optional.get());
		}
		throw new ExceptionHandlerAdvice();
	}

	@Transactional
	public ProductDTO createProductCommand(ProductSubmit submit) {
		Product product = convertToBusiness(submit);
		if(submit.getMinPrince() > submit.getPrice()) {
			throw new MinPriceValidation();
		}else {
			product = repository.save(product);
		}
		return convertToDto(product);
	}

	/*@Transactional
	public ProductDTO UpdateProductCommand(ProductUpdate update, Long Id) {
		Optional<Product> op = repository.findById(Id);
		if(op.isPresent()) {
			Product obj = op.get();
			if(update.getDescription() != null 
					&& update.getMinPrince() != null 
					&& form.getPhoneNumber() != null 
					&& form.getEmail() != null) {
				obj.setAddress(form.getAddress());
				obj.setPostCode(form.getPostCode());
				obj.setPhoneNumber(form.getPhoneNumber());
				obj.setEmail(form.getEmail());
			}
			repository.save(obj);
			return convertToDto(obj);
		}
		return null;
	}*/

	@Transactional
	public void deleteById(Long id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
			throw new ClientDeleted();
		}else {
			throw new ExceptionHandlerAdvice();
		}
	}
	
	public Product convertToBusiness(ProductSubmit submit) {
		Product product = new Product();
		product.setCode(submit.getCode());
		product.setDescription(submit.getDescription());
		product.setPrice(submit.getPrice());
		product.setMinPrince(submit.getMinPrince());
		product.setStockQuantity(submit.getStockQuantity());
		return product;
	}
	
	public ProductDTO convertToDto(Product product) {
		ProductDTO dto = new ProductDTO();
		dto.setId(product.getId());
		dto.setCode(product.getCode());
		dto.setDescription(product.getDescription());
		dto.setPrice(product.getPrice());
		dto.setMinPrince(product.getMinPrince());
		dto.setStockQuantity(product.getStockQuantity());
		return dto;
	}

	@Override
	public ProductDTO UpdateProductCommand(ProductUpdate update, Long Id) {
		// TODO Auto-generated method stub
		return null;
	}
}
