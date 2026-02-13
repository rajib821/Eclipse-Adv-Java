package com.zepto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZeptoBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZeptoBootApplication.class, args);
		System.out.println("This is payment application...");
	}

}
