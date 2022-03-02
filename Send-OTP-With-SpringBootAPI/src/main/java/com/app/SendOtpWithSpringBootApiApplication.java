package com.app;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.app")
public class SendOtpWithSpringBootApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendOtpWithSpringBootApiApplication.class, args);
		System.out.println("Hello I am Running Fine");
	}

}
