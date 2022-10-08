package com.sojern.mathapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Math Api", version = "1.0", description = "Math api calculates values for you"))
public class MathApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MathApiApplication.class, args);
	}

}
