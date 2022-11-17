package com.dambroski.SpringSecuirtyUdemy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.jboss.logging.Logger;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthoritiesLoggingAfterFilter implements Filter{
	
	private final Logger LOG = Logger.getLogger(AuthoritiesLoggingAfterFilter.class.getName());

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(null != authentication) {
			LOG.info("User " + authentication.getName() + " is sucessfully authenticated and "
					+ " has te authorites " + authentication.getAuthorities().toString());
		}
		
		chain.doFilter(request, response);
		
	}

}
