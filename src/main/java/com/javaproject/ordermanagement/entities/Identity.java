package com.javaproject.ordermanagement.entities;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Identity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private UUID uuid = UUID.randomUUID();

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@JsonIgnore
	private Date createdBy = new Date();

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@JsonIgnore
	private Date updatedBy = new Date();

	public Identity() {
	}

	public Identity(UUID uuid, Date createdBy, Date updatedBy) {
		super();
		this.uuid = uuid;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	@JsonIgnore
	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	@JsonIgnore
	public Date getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Date createdBy) {
		this.createdBy = createdBy;
	}

	@JsonIgnore
	public Date getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Date updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Identity other = (Identity) obj;
		return Objects.equals(uuid, other.uuid);
	}

}
