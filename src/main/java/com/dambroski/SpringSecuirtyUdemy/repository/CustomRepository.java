package com.dambroski.SpringSecuirtyUdemy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dambroski.SpringSecuirtyUdemy.model.Customer;

@Repository
public interface CustomRepository extends CrudRepository<Customer, Long> {

}
