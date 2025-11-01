package com.todoapp.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@Configuration
@ComponentScan(basePackages = "com.todoapp")
@EntityScan(basePackages = "com.todoApp")
@EnableJpaRepositories(basePackages = {"com.todoapp"})
@SpringBootApplication
public class PracticeForSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeForSpringApplication.class, args);
	}



}
