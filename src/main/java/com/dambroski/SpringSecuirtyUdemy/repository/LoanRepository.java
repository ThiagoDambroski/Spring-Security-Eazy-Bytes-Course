package com.dambroski.SpringSecuirtyUdemy.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dambroski.SpringSecuirtyUdemy.model.Loans;

@Repository
public interface LoanRepository extends CrudRepository<Loans, Long>{
	
	List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);

}
