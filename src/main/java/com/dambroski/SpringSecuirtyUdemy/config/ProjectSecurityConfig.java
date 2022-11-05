package com.dambroski.SpringSecuirtyUdemy.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
	
	
	@Bean
	SecurityFilterChain customSecurityFilterChain(HttpSecurity http) throws Exception{
		http
		.csrf().disable()
		.authorizeHttpRequests()
			.antMatchers("/myAccount","myBalance","/myLoans","/myCards").authenticated()
			.antMatchers("/notices","/contact","/register").permitAll()
		.and().httpBasic()
		.and().formLogin();
		
		
		return http.build();
	}
	
//	@Bean 
//	public UserDetailsService userDetailsService(DataSource dataSource) {  
//	  return new JdbcUserDetailsManager(dataSource); 
//	}   
	
	
	@Bean
	public PasswordEncoder passWordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
