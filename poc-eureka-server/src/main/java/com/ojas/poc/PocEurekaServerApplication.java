package com.ojas.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PocEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocEurekaServerApplication.class, args);
	}

}
