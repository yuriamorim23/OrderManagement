package com.javaproject.ordermanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaproject.ordermanagement.entities.OrderPayments;

public interface OrderPaymentsRepository extends JpaRepository<OrderPayments, Long> {

}
