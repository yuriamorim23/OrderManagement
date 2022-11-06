package com.javaproject.ordermanagement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaproject.ordermanagement.entities.UserModel;

@Repository
public interface UserModelRepository extends JpaRepository<UserModel, Long> {

	Optional<UserModel> findByUsername(String username);

}
