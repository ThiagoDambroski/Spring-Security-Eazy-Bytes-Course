package com.dambroski.SpringSecuirtyUdemy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
	
//	@Bean
//	public InMemoryUserDetailsManager userDetailsService() {
//		
//		UserDetails admin = User.withDefaultPasswordEncoder()
//				.username("thiago")
//				.password("123")
//				.authorities("admin")
//				.build();
//	
//		UserDetails leticia = User.withDefaultPasswordEncoder()
//				.username("leticia")
//				.password("linda")
//				.authorities("read")
//				.build();
//	
//		return new InMemoryUserDetailsManager(admin,leticia);
//	}
	
	
	//second approach
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		
		UserDetails admin = User.withUsername("thiago")
				.password("123")
				.authorities("admin")
				.build();
	
		UserDetails leticia = User.withUsername("leticia")
				.password("linda")
				.authorities("read")
				.build();
	
		return new InMemoryUserDetailsManager(admin,leticia);
	}
	
	
	@Bean
	public PasswordEncoder passWordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
