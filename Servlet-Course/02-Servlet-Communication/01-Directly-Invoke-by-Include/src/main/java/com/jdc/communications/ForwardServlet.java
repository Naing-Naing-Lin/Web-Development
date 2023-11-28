package com.jdc.communications;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/forwardServlet")
public class ForwardServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// forward Message sent by request
		req.setAttribute("forwardMessage", "Message from Forward Servlet");
		
		// By using (ServletContext -> Absolute Path)
		getServletContext().getRequestDispatcher("/forward-to").forward(req, resp);
	}
}
