package com.dambroski.SpringSecuirtyUdemy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dambroski.SpringSecuirtyUdemy.model.Accounts;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Long>{
	
	Accounts findByCustomerId(int id);

}
