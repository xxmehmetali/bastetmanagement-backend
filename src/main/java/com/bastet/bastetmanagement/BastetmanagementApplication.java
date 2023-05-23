package com.bastet.bastetmanagement;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BastetmanagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(BastetmanagementApplication.class, args);
	}
}
