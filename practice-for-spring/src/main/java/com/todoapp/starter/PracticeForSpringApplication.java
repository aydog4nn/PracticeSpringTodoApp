package com.todoapp.starter;

import com.todoapp.configuration.GlobalProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@Configuration
@ComponentScan(basePackages = "com.todoapp")
@EntityScan(basePackages = "com.todoApp")
@EnableJpaRepositories(basePackages = {"com.todoapp"})
@SpringBootApplication
@EnableConfigurationProperties(value = GlobalProperties.class)
public class PracticeForSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeForSpringApplication.class, args);
	}



}
