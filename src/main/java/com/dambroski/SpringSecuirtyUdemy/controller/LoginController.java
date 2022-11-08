package com.dambroski.SpringSecuirtyUdemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dambroski.SpringSecuirtyUdemy.model.Customer;
import com.dambroski.SpringSecuirtyUdemy.repository.CustomerRepository;

@RestController
public class LoginController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	
	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer(@RequestBody Customer customer) {
		Customer savedCustomer = null;
		ResponseEntity response = null;
		try {
			savedCustomer = customerRepository.save(customer);
			if(savedCustomer.getId() > 0) {
				response = ResponseEntity.status(HttpStatus.CREATED).body("sucess");
			}
		}catch(Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e);
		}
		
		return response;
	}

}
