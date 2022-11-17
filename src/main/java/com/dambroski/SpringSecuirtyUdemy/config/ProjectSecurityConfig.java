package com.dambroski.SpringSecuirtyUdemy.config;


import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.dambroski.SpringSecuirtyUdemy.filter.AuthoritiesLoggingAfterFilter;
import com.dambroski.SpringSecuirtyUdemy.filter.AuthoritiesLoggingAtFilter;
import com.dambroski.SpringSecuirtyUdemy.filter.RequestValidationBeforeFilter;

@Configuration
public class ProjectSecurityConfig {
	
	
	
	 @Bean
	    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
	        http.securityContext().requireExplicitSave(false)
	            .and().cors().configurationSource(new CorsConfigurationSource() {
	            @Override
	            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
	                CorsConfiguration config = new CorsConfiguration();
	                config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
	                config.setAllowedMethods(Collections.singletonList("*"));
	                config.setAllowCredentials(true);
	                config.setAllowedHeaders(Collections.singletonList("*"));
	                config.setMaxAge(3600L);
	                return config;
	            }

		
		}).and().csrf().ignoringAntMatchers("/contact","/register")
						.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		.and()
		.addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
		.addFilterAt(new AuthoritiesLoggingAtFilter(), BasicAuthenticationFilter.class)
		.addFilterAfter(new AuthoritiesLoggingAfterFilter(),BasicAuthenticationFilter.class)
		.authorizeHttpRequests()
			.antMatchers("/myAccount").hasRole("USER")
			.antMatchers("myBalance").hasAnyRole("USER","ADMIN")
			.antMatchers("/myLoans").hasRole("USER")
			.antMatchers("myCards").hasRole("USER")
			.antMatchers("/user").authenticated()
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
