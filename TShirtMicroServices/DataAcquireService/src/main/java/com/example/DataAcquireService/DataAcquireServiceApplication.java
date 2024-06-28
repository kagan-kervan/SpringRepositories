package com.example.DataAcquireService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataAcquireServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataAcquireServiceApplication.class, args);
	}

	public static void startApplication() {
		String[] args = new String[] {
				"--spring.application.name=DataAcquireService",
				"--server.port=8081"
		};
		main(args);
	}
}
