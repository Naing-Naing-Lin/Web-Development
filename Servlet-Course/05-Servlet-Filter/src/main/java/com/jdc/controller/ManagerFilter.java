package com.jdc.controller;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter("/manager/*")
public class ManagerFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		var req = (HttpServletRequest) request;
		var session = req.getSession(true);
		
		var user = (String) session.getAttribute("user");
		var role = (String) session.getAttribute("role");
		
		if(user != null && role!= null) {
			if(("Manager").equalsIgnoreCase(role)) {
				
				chain.doFilter(request, response);
			}else {
				req.setAttribute("message", "Sorry! Access Denied. Only for Manager Role");
				req.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}else {
			req.setAttribute("message", "Sorry! You should have a role.");
			req.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
	}

}
