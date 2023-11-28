package com.jdc.servlet_annotation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/annotationServlet")
public class AnnotationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AnnotationServlet() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	// Way-1
    	
//		response.getWriter().append("""
//				
//				<!DOCTYPE html>
//				<html>
//					<head>
//						<title>Servlet by Annotation</title>
//					</head>
//					
//					<body>
//						<p>Welcome to Servlet defined by Annotation</p>
//					</body>
//				</html>
//				
//				""").flush();
		
    	
    	// Way-2
    	
		request.setAttribute("message", "Welcome from Hello Servlet.");
		getServletContext().getRequestDispatcher("/hello.jsp").forward(request, response);
		
	}

	

}
