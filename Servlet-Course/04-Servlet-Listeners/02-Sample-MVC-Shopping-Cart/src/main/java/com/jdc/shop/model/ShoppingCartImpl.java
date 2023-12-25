package com.jdc.shop.model;

import java.util.ArrayList;
import java.util.List;

import com.jdc.shop.model.entity.Product;
import com.jdc.shop.model.entity.SaleItem;

class ShoppingCartImpl implements ShoppingCart{

	private static final long serialVersionUID = 1L;

	private List<SaleItem> items;
	
	public ShoppingCartImpl() {
		items = new ArrayList<SaleItem>();
	}
	
	@Override
	public void add(Product product) {
		
		var item = checkItem(product);
		
		if(item == null) {
			item = new SaleItem();
			item.setProduct(product);
			
			items.add(item);
		}
		item.countUp();
	}

	@Override
	public void clear() {
		
		items.clear();
	}

	@Override
	public int itemCount() {
		
		int count = 0;
		for(SaleItem item : items) {
			count += item.getCount();
		}
		
		return count;
	}

	@Override
	public int total() {
		
		int totalPrice = 0;
		for(SaleItem item : items) {
			totalPrice += item.getTotal();
		}
		
		return totalPrice;
	}

	
	private SaleItem checkItem(Product product) {
		
		for(SaleItem item : items) {
			if(item.getProduct().getId() == product.getId()) {
				return item;
			}
		}
		
		return null;
	}

	@Override
	public List<SaleItem> items() {
		
		return new ArrayList<SaleItem>(items);
	}

	@Override
	public void changeItemCount(boolean isPlus, int productId) {
		
		for(SaleItem item : items) {
			if(item.getProduct().getId() == productId) {
				
				if(isPlus != true) {
					item.countDown();
					
					if(item.getCount() == 0) {
						items.remove(item);
					}
				}else {
					item.countUp();
				}
			}
		}
	}
	
}
