package com.demo.sunat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SunatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SunatApplication.class, args);
	}

}
