package com.unitbv.tema2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories({ "com.unitbv.tema2.repository" })
@ComponentScan(basePackages = "com.unitbv.tema2")
@EntityScan(basePackages = "com.unitbv.tema2.model")
@SpringBootApplication
public class Tema2Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Tema2Application.class, args);
	}
}
