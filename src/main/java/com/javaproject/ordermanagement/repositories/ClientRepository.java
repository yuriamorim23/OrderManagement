package com.javaproject.ordermanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaproject.ordermanagement.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	
}
