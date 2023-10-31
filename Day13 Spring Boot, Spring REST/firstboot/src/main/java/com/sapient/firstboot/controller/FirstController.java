package com.sapient.firstboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello";
	}

	@RequestMapping("/hello1")
	public String hello1() {
		return "Hello1";
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Spring Boot";
	}
}
