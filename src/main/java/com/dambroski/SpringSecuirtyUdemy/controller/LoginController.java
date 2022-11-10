package com.dambroski.SpringSecuirtyUdemy.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dambroski.SpringSecuirtyUdemy.model.Customer;
import com.dambroski.SpringSecuirtyUdemy.repository.CustomerRepository;

@RestController
public class LoginController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer(@RequestBody Customer customer) {
		Customer savedCustomer = null;
		ResponseEntity response = null;
		try {
			String passwrod = passwordEncoder.encode(customer.getPwd());
			customer.setPwd(passwrod);
			Date d = new Date(System.currentTimeMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-");
			String date = sdf.format(d);
			System.out.println(date);
			customer.setCreateDt(date);
			savedCustomer = customerRepository.save(customer);
			if(savedCustomer.getId() > 0) {
				response = ResponseEntity.status(HttpStatus.CREATED).body("sucess");
			}
		}catch(Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e);
		}
		
		return response;
	}
	
	@RequestMapping("/user")
    public Customer getUserDetailsAfterLogin(Authentication authentication) {
        List<Customer> customers = customerRepository.findByEmail(authentication.getName());
        if (customers.size() > 0) {
            return customers.get(0);
        } else {
            return null;
        }

    }

}
