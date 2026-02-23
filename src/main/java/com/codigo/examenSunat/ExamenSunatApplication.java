package com.codigo.examenSunat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ExamenSunatApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenSunatApplication.class, args);
	}

}
