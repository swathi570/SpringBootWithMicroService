package com.ojas.poc.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ojas.poc.model.CreateUser;

public interface UserRepository  extends JpaRepository<CreateUser, Integer>{
	
	 public Optional<CreateUser> findByUserName(String userName);

}
