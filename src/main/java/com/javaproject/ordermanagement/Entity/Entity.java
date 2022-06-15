package com.javaproject.ordermanagement.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Entity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID uuid = UUID.randomUUID();
	
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
	private Date createDate = new Date();
	
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
	private Date updateDate = new Date();

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}
