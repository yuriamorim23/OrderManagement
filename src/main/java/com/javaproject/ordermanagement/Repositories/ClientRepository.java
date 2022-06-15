package com.javaproject.ordermanagement.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaproject.ordermanagement.Entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

}
