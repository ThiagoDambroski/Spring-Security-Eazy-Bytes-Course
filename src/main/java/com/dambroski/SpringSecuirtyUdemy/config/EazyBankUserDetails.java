package com.dambroski.SpringSecuirtyUdemy.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dambroski.SpringSecuirtyUdemy.model.Customer;
import com.dambroski.SpringSecuirtyUdemy.repository.CustomerRepository;

@Service
public class EazyBankUserDetails implements UserDetailsService{
	
	@Autowired
	CustomerRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		String userName,password = null;
		List<GrantedAuthority> authorites = null;
		List<Customer> customer = repository.findByEmail(username);
		if(customer.size() == 0) {
			throw new UsernameNotFoundException("User details no found");
		}else {
			userName = customer.get(0).getEmail();
			password = customer.get(0).getPwd();
			authorites = new ArrayList<>();
			authorites.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
		}
		return new User(username,password,authorites);
	}

}
