package com.javaproject.ordermanagement.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Order_Payment")
public class OrderPayments implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "payment_id")
	private PaymentMethod paymentId;
	
	private Double value;

	public OrderPayments() {}

	public OrderPayments(Long id, Order order, PaymentMethod paymentId, Double value) {
		super();
		this.id = id;
		this.order = order;
		this.paymentId = paymentId;
		this.value = value;
	}
	
	public OrderPayments(Order order,PaymentMethod paymentId, Double value) {
		this.order = order;
		this.paymentId = paymentId;
		this.value = value;
	}

	public OrderPayments(OrderPayments orderPayments, PaymentMethod paymentMethod, Double value2) {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public PaymentMethod getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(PaymentMethod paymentId) {
		this.paymentId = paymentId;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
