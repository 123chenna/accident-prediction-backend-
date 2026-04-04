package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import com.example.demo.service.Dataset;

@SpringBootApplication
public class RoadAccidentPredictionApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoadAccidentPredictionApplication.class, args);
	}

	// 🔥 ADD THIS BELOW main method
	@Bean
	CommandLineRunner run(Dataset dataset) {
		return args -> {
			dataset.loadData();   // ✅ this will load CSV automatically
		};
	}
}