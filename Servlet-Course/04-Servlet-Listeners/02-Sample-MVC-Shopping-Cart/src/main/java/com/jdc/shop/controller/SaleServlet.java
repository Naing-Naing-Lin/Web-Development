package com.jdc.shop.controller;

import java.io.IOException;

import com.jdc.shop.model.SaleModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {
		"/sale-list"
})
public class SaleServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private SaleModel model;
	
	@Override
	public void init() throws ServletException {
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		switch (req.getServletPath()) {
		case "sale-list": showSaleHistory(req, resp) ;
		
		default : throw new RuntimeException();
		}
	}

	private void showSaleHistory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var saleVoucherLists = model.getSaleHistory();
		
		req.setAttribute("data", saleVoucherLists);
		
		getServletContext().getRequestDispatcher("/sale-list.jsp").forward(req, resp);
	}
}
