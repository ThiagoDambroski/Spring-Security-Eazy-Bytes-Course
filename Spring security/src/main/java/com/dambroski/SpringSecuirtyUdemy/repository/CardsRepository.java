package com.dambroski.SpringSecuirtyUdemy.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dambroski.SpringSecuirtyUdemy.model.Cards;

@Repository
public interface CardsRepository extends CrudRepository<Cards, Long>{
	
	List<Cards> findByCustomerId(int customerId);

}
