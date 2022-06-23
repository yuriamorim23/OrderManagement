package com.javaproject.ordermanagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaproject.ordermanagement.Entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
