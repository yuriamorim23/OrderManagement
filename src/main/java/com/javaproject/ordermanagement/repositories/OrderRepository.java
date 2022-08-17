package com.javaproject.ordermanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaproject.ordermanagement.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
