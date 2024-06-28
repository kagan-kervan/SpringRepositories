package com.example.SaleServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SaleServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaleServicesApplication.class, args);
	}

	public static void startApplication() {
		String[] args = new String[] {
				"--spring.application.name=SaleServices",
				"--server.port=8080",
				"--spring.datasource.url=jdbc:mariadb://localhost:3316/tshirt_service?allowPublicKeyRetrieval=true&useSSL=false",
				"--spring.datasource.username=tshirt_user",
				"--spring.datasource.password=password",
				"--spring.datasource.driver-class-name=org.mariadb.jdbc.Driver",
				"--spring.jpa.hibernate.ddl-auto=update",
				"--spring.jpa.show-sql=true",
				"--spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDBDialect"
		};
		main(args);
	}

}
