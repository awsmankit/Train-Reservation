package com.train;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication 
public class TrainReservationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainReservationSystemApplication.class, args);
	}

}
