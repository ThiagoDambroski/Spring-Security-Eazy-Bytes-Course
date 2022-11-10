package com.dambroski.SpringSecuirtyUdemy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dambroski.SpringSecuirtyUdemy.model.AccountTransactions;
import com.dambroski.SpringSecuirtyUdemy.repository.AccountsTransactionsRepository;

@RestController
public class BalanceController {
	
	
	 @Autowired
	 private AccountsTransactionsRepository accountTransactionsRepository;
	
	@GetMapping("/myBalance")
	 public List<AccountTransactions> getBalanceDetails(@RequestParam int id) {
        List<AccountTransactions> accountTransactions = accountTransactionsRepository.
                findByCustomerIdOrderByTransactionDtDesc(id);
        if (accountTransactions != null ) {
            return accountTransactions;
        }else {
            return null;
        }
    }

}
