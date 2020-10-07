package com.ojas.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Poc4Application {

	public static void main(String[] args) {
		SpringApplication.run(Poc4Application.class, args);
	}

}
