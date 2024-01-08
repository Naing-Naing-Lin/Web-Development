package com.jdc.shop.controller;

import java.io.IOException;

import com.jdc.shop.model.SaleModel;
import com.jdc.shop.model.ShoppingCart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({
		"/sale-list",
		"/sale-details",
		"/check-out"
})
public class SaleServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private SaleModel model;
	
	@Override
	public void init() throws ServletException {
		model = (SaleModel) getServletContext().getAttribute("saleData");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		switch (req.getServletPath()) {
		case "/sale-list": showSaleHistory(req, resp) ;
		case "/sale-details": showSaleDetails(req, resp);
		
		default : throw new RuntimeException();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var customer = req.getParameter("customer");
		var cart = (ShoppingCart) req.getSession().getAttribute("cart");
		
		var voucherId = model.create(cart, customer);
		
		req.getSession().removeAttribute("cart");
		resp.sendRedirect(getServletContext().getContextPath().concat("/sale-details?voucherId=")+voucherId);		
		
	}

	private void showSaleDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var voucherId = Integer.parseInt(req.getParameter("voucherId"));
		var data = model.findByVoucherId(voucherId);
		
		req.setAttribute("data", data);
		
		getServletContext().getRequestDispatcher("/sale-details.jsp").forward(req, resp);
	}

	private void showSaleHistory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var saleVoucherLists = model.getSaleHistory();
		
		req.setAttribute("data", saleVoucherLists);
		
		getServletContext().getRequestDispatcher("/sale-list.jsp").forward(req, resp);
	}
}
