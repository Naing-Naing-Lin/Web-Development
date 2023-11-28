package com.jdc.servlet;

import java.io.IOException;

import com.jdc.Counter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(
		urlPatterns = {"/", "/counter", "/session-stop"}
		)
public class CounterServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// There are 3 servlet scopes
		
		// 1) Request Scope
		
		Counter reqCounter = (Counter) req.getAttribute("reqCounter");
		
		if(null == reqCounter) {
			reqCounter = new Counter();
			req.setAttribute("reqCounter", reqCounter);
		}
		reqCounter.countUp();
		
		
		
		// 2) Session Scope
		
		HttpSession session = req.getSession(true);
		Counter sessionCounter = (Counter) session.getAttribute("sessionCounter");
		
		if(null == sessionCounter) {
			sessionCounter = new Counter();
			session.setAttribute("sessionCounter", sessionCounter);
		}
		sessionCounter.countUp();
		
		
		// 3) Application Scope
		ServletContext context = getServletContext();
		Counter applicationCounter = (Counter) context.getAttribute("applicationCounter");
		
		if(null == applicationCounter) {
			applicationCounter = new Counter();
			context.setAttribute("applicationCounter", applicationCounter);
		}
		applicationCounter.countUp();
		

		// finally forward to jsp
		getServletContext().getRequestDispatcher("/ScopesDemo.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getSession().invalidate();
		
		resp.sendRedirect("counter");
		//resp.sendRedirect(req.getContextPath().concat("/counter"));		
		
	}
}
