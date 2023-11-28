package com.jdc.shop.model;

import java.io.Serializable;

import com.jdc.shop.model.entity.Product;


public interface ShoppingCart extends Serializable{

	void add(Product product);
	void clear();
	int itemCount();
	int total();
	
	public static ShoppingCart generate() {
		return null;
	}
}
