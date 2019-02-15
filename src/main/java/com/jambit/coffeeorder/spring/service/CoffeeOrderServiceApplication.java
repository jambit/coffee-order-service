package com.jambit.coffeeorder.spring.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class CoffeeOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeOrderServiceApplication.class, args);
	}
}
