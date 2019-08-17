package com.melvin.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	
	@GetMapping("/hello")
	public String sayhello() {
		return"HELLO WORLD";
	}
}
