package com.api.parking_ctrl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ParkingCtrlApplication {
	public static void main(String[] args) {
		SpringApplication.run(ParkingCtrlApplication.class, args);
		System.out.println("Parking Ctrl API started successfully.");
	}
	@GetMapping("/")
	public String index(){
		return "Welcome to Parking Ctrl API!";
	}

}
