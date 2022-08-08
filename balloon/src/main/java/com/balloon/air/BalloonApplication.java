package com.balloon.air;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan(basePackages = {"com.balloon.entity"})
@EnableJpaRepositories(basePackages = {"com.balloon.repository"})
@ComponentScan(basePackages = {"com.balloon.controller","com.balloon.api","com.balloon.service","com.balloon.socket"})
public class BalloonApplication {

	public static void main(String[] args) {
		SpringApplication.run(BalloonApplication.class, args);
		
	}

}
