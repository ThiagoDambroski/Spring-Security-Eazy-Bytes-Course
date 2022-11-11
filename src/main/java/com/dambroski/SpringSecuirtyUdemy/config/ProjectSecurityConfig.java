package com.dambroski.SpringSecuirtyUdemy.config;

import java.util.Collection;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
public class ProjectSecurityConfig {
	
	
	
	@Bean
	SecurityFilterChain customSecurityFilterChain(HttpSecurity http) throws Exception{
		http.cors().configurationSource(new CorsConfigurationSource() {
			
			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				CorsConfiguration config = new CorsConfiguration();
				config.setAllowedOriginPatterns(Collections.singletonList("http://localhost:4200"));
				config.setAllowedMethods(Collections.singletonList("*"));
				config.setAllowCredentials(true);
				config.setAllowedHeaders(Collections.singletonList("*"));
				config.setMaxAge(3600L);
				return config;
			}
		}).and().csrf().disable()
		.authorizeHttpRequests()
			.antMatchers("/myAccount","myBalance","/myLoans","/myCards","/user").authenticated()
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
	public BCryptPasswordEncoder passWordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
