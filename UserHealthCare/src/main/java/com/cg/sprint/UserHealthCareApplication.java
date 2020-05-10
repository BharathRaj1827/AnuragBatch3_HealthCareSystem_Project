package com.cg.sprint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UserHealthCareApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserHealthCareApplication.class, args);
	}

}
