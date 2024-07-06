package com.example.TShirtMicroService;

import com.example.DataAcquireService.DataAcquireServiceApplication;
import com.example.SaleServices.SaleServicesApplication;
import com.example.AuthenticationAndAuthorizationService.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TShirtMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TShirtMicroServiceApplication.class, args);
		SaleServicesApplication.startApplication();
		DataAcquireServiceApplication.startApplication();
		AuthenticationAndAuthorizationServiceApplication.startApplication();
	}

}
