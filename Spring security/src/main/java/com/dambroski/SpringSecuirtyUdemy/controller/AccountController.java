package com.dambroski.SpringSecuirtyUdemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dambroski.SpringSecuirtyUdemy.model.Accounts;
import com.dambroski.SpringSecuirtyUdemy.repository.AccountsRepository;

@RestController
public class AccountController {
	@Autowired
	private AccountsRepository accountsRepository;
	
	@GetMapping("/myAccount")
	 public Accounts getAccountDetails(@RequestParam int id) {
        Accounts accounts = accountsRepository.findByCustomerId(id);
        if (accounts != null ) {
            return accounts;
        }else {
            return null;
        }
    }
}
