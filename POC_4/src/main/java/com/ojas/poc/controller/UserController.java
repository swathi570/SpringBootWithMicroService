package com.ojas.poc.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.poc.model.CreateUser;
import com.ojas.poc.serviceimpl.UserServiceImpl;

@RestController
@RequestMapping("/poc/user")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	static Logger log = Logger.getLogger(UserController.class.getName());

	@PostMapping(path = "/createuser", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> saveUser(@RequestBody CreateUser userReq) {
		log.debug("Incoming request user controller : " + userReq);
		return userService.saveUser(userReq);
	}

}
