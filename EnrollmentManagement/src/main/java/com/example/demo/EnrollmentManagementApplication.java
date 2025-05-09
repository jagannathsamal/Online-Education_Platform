package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EnrollmentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnrollmentManagementApplication.class, args);
	}

}
