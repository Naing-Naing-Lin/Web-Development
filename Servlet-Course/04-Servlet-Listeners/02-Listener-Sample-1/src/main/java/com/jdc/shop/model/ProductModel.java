package com.jdc.shop.model;

import java.util.ArrayList;
import java.util.List;

import com.jdc.shop.model.entity.Product;

public class ProductModel {

	private List<Product> productList;
	
	public ProductModel() {
		productList = new ArrayList<Product>();
	}
	
	public void add(Product product) {
		productList.add(product);
		product.setId(productList.size());
	}
	
	public List<Product> getList(){
		return productList;
	}
	
	public Product findById(int id) {
		for(Product p : productList) {
			if(p.getId() == id) {
				return p;
			}
		}
		return null;
		
	}
	
}
