package com.dambroski.SpringSecuirtyUdemy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dambroski.SpringSecuirtyUdemy.model.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long>{

}
