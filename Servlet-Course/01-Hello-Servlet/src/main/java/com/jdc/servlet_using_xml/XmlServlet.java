package com.jdc.servlet_using_xml;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class XmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		
		log("Initializing Method");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		log("Get Method Invoke");
		
		response.getWriter().append("""
				<!DOCTYPE html>
				<html>
					<head>
						<title> Servlet Using XML </title>
					</head>
					<body>
						<p> Welcome from Servlet defined in xml </p>
					</body>
				</html>
				""").flush();
	}
	
	@Override
	public void destroy() {
		log("Destroy Method");
	}

}
