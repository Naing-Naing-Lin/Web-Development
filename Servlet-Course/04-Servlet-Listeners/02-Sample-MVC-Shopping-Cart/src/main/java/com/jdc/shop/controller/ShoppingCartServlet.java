package com.jdc.shop.controller;

import java.io.IOException;

import com.jdc.shop.model.ProductModel;
import com.jdc.shop.model.ShoppingCart;
import com.jdc.shop.model.entity.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({
	"/addToCart",
	"/showCart",
	"/clearCart",
	"/cart-minus",
	"/cart-plus"
})
public class ShoppingCartServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		switch(req.getServletPath()) {
		
		case "/addToCart" : addToCart(req, resp); break;
		case "/showCart" :  showCart(req, resp); break;
		case "/clearCart" : clearCart(req, resp); break;
		case "/cart-plus" :
		case "/cart-minus" : changeCartItem(req, resp); break;
		default : throw new RuntimeException();
		}
		
	}
	
	private void changeCartItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		var productId = req.getParameter("product");
		
		var cart = (ShoppingCart) req.getSession(true).getAttribute("cart");
		
		var isPlus = ("/cart-plus").equals(req.getServletPath());
		
		cart.changeItemCount(isPlus, Integer.parseInt(productId));
		
		resp.sendRedirect("showCart");
	}

	private void showCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher("/cart-list.jsp").forward(req, resp);
		
	}

	private void addToCart (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Get Product ID
		var productId = req.getParameter("productID");
		
		// Get Product Model from Application Scope
		var productModel = (ProductModel) getServletContext().getAttribute("products");
		
		// Find product from model by productId
		Product product = productModel.findById(Integer.parseInt(productId));
		
		// Get shopping cart from Session Scope
		var session = req.getSession(true);
		var cart = (ShoppingCart)session.getAttribute("cart");
		
		if(null == cart) {
			// create shopping cart
			cart = ShoppingCart.generate();
			
			// add cart to session scope
			session.setAttribute("cart", cart);
		}
		
		// Add product to shopping cart
		cart.add(product);
		
		// Forward index.jsp
		getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	
	private void clearCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		// get Session
		var session = req.getSession();
		
		// get Attribute && Clear cart
		if(session != null) {
			ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
			cart.clear();
		}
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
		
	}

}
