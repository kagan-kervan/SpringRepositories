package com.example.AuthenticationAndAuthorizationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthenticationAndAuthorizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationAndAuthorizationServiceApplication.class, args);
	}

	public static void startApplication() {
		String[] args = new String[] {
				"--spring.application.name=AuthenticationAndAuthorizationService",
				"--server.port=8085",
				"--spring.datasource.url=jdbc:mariadb://localhost:3316/tshirt_service_auth?allowPublicKeyRetrieval=true&useSSL=false",
				"--spring.datasource.username=user",
				"--spring.datasource.password=password",
				"--spring.datasource.driver-class-name=org.mariadb.jdbc.Driver",
				"--spring.jpa.hibernate.ddl-auto=update",
				"--spring.jpa.show-sql=true",
				"--spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDBDialect"
		};
		main(args);
	}

}
