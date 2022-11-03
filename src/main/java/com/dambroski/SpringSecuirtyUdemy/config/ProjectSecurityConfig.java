package com.dambroski.SpringSecuirtyUdemy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
	
	
	@Bean
	SecurityFilterChain customSecurityFilterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests()
			.antMatchers("/myAccount","myBalance","/myLoans","/myCards").authenticated()
			.antMatchers("/notices","/contact").permitAll()
		.and().httpBasic()
		.and().formLogin();
		
		
		return http.build();
	}

}
