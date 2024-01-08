package com.jdc.controller;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter("/employee/*")
public class EmployeeFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		var req = (HttpServletRequest) request;
		var session = req.getSession(true);
		
		var user = (String) session.getAttribute("user");
		var role = (String) session.getAttribute("role");
		
		if(user != null && role!= null) {
			if(("Employee").equalsIgnoreCase(role) && ("Manager").equalsIgnoreCase(role)) {
				
				chain.doFilter(request, response);
			}
		}else {
			req.setAttribute("message", "Sorry! T.");
			req.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
	}

}
