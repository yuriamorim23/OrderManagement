package com.javaproject.ordermanagement.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaproject.ordermanagement.entities.Order;
import com.javaproject.ordermanagement.entities.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

	@Transactional
	List<OrderItem> findByOrder(Order order);
}
