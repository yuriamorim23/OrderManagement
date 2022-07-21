package com.javaproject.ordermanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaproject.ordermanagement.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
