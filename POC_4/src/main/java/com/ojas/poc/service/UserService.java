package com.ojas.poc.service;

import org.springframework.http.ResponseEntity;

import com.ojas.poc.model.CreateUser;

public interface UserService {
	
	public ResponseEntity<Object> saveUser(CreateUser user) throws Exception;

}
