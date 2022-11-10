package com.dambroski.SpringSecuirtyUdemy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Accounts {
	
	@Column(name = "customer_id")
	private int customerId;
	
	@Id
	@Column(name = "account_type")
	private long accountNumber;
	
	@Column(name = "branch_adress")
	private String branchAdress;
	
	@Column(name = "create_dt")
	private String createDt;
	
}
