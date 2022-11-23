package com.dambroski.SpringSecuirtyUdemy.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dambroski.SpringSecuirtyUdemy.model.AccountTransactions;

@Repository
public interface AccountsTransactionsRepository extends CrudRepository<AccountTransactions, Long> {
	
	List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(int customerId);
}
