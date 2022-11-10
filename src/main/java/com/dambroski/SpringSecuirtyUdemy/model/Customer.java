package com.dambroski.SpringSecuirtyUdemy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
	@GenericGenerator(name = "native",strategy = "native")
	@Column(name = "customer_id")
	private int id;
	
	private String name;

	private String email;
	
	@Column(name = "mobile_number")
	private String mobileNumber;
	
	//@JsonIgnore
	private String pwd;
	
	private String role;
	
	@Column(name = "create_dt")
	private String createDt;
	

}
