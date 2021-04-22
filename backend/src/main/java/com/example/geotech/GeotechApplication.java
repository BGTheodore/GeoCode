package com.example.geotech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@SpringBootApplication
public class GeotechApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeotechApplication.class, args);
	}

	@Bean
	LayoutDialect thymeleafDialect(){
		return new LayoutDialect();
	}
}
