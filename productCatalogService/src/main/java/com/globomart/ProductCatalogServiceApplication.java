package com.globomart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author nahusha
 *
 */
@SpringBootApplication
public class ProductCatalogServiceApplication {
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "application");
		SpringApplication.run(ProductCatalogServiceApplication.class, args);
	}
}
