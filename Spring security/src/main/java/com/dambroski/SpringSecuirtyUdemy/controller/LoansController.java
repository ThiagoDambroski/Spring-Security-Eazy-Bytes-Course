package com.dambroski.SpringSecuirtyUdemy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dambroski.SpringSecuirtyUdemy.model.Loans;
import com.dambroski.SpringSecuirtyUdemy.repository.LoanRepository;

@RestController
public class LoansController {
	
	@Autowired
    private LoanRepository loanRepository;

	@GetMapping("/myLoans")
	@PostAuthorize("hasRole('USER')")
	 public List<Loans> getLoanDetails(@RequestParam int id) {
        List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(id);
        if (loans != null ) {
            return loans;
        }else {
            return null;
        }
    }

}
