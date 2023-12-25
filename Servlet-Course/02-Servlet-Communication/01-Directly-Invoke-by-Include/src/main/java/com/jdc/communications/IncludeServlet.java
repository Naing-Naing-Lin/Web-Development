package com.jdc.communications;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/includeServlet")
public class IncludeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// There are 3 ways
		// Include Message (ServletRequest -> Relative Path)
		// HeaderInclude Servlet
		req.getRequestDispatcher("headerInclude").include(req, resp);
		
		
		
		// Include Message (ServletContext -> Absolute Path)
		// MessageInclude Servlet
		getServletContext().getRequestDispatcher("/messageInclude").include(req, resp);
		
		
		
		// Include Message (ServletContext -> Servlet Name)
		// FooterInclude Servlet
		getServletContext().getNamedDispatcher("FooterInclude").include(req, resp);
		
	}
}
