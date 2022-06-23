package com.javaproject.ordermanagement.Entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Identify {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID uuid = UUID.randomUUID();
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date createdBy = new Date();
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date updatedBy = new Date();
	
	public Identify() {}

	public Identify(UUID uuid, Date createdBy, Date updatedBy) {
		super();
		this.uuid = uuid;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public Date getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Date createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Date updatedBy) {
		this.updatedBy = updatedBy;
	}
	
}
