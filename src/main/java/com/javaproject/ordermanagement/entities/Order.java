package com.javaproject.ordermanagement.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.javaproject.ordermanagement.enums.OrderStatus;

@Entity
@Table(name = "Order_Client")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	private String clientName;

	private String moreInfo;
	private OrderStatus status;

	private Double total;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date closeSoldDate;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItems = new ArrayList<>();

	public Order() {
	}

	public Order(Long id, Client client, String clientName, String moreInfo, OrderStatus status, Double total,
			Date closeSoldDate, List<OrderItem> orderItems) {
		super();
		this.id = id;
		this.client = client;
		this.clientName = clientName;
		this.moreInfo = moreInfo;
		this.status = status;
		this.total = total;
		this.closeSoldDate = closeSoldDate;
		this.orderItems = orderItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getMoreInfo() {
		return moreInfo;
	}

	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Date getCloseSoldDate() {
		return closeSoldDate;
	}

	public void setCloseSoldDate(Date closeSoldDate) {
		this.closeSoldDate = closeSoldDate;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
