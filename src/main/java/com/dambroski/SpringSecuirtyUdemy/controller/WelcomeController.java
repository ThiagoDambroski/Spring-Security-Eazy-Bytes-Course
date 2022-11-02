package com.dambroski.SpringSecuirtyUdemy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello World !";
	}

}
