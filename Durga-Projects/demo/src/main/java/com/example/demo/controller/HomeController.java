package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/sayHello")
	public String sayHelloRequest() {
		return "Hello Wlcome To Spring Boot";
	}

}
