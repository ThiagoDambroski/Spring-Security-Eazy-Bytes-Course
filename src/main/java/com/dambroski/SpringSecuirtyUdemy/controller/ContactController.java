package com.dambroski.SpringSecuirtyUdemy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

	@GetMapping("/contact")
	public String getContactInquieyDetails() {
		return "contact Inquiey detaisl";
	}
}
