package com.jdc.shop.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.jdc.shop.model.entity.Voucher;

public class SaleModelImpl implements SaleModel{

	private List<Voucher> voucherLists;
	
	public SaleModelImpl() {
		
		voucherLists = new ArrayList<Voucher>();
	}
	
	@Override
	public List<Voucher> getSaleHistory() {
		
		return new ArrayList<Voucher>(voucherLists);
	}

	@Override
	public Voucher findByVoucherId(int voucherId) {
		
		for(Voucher voucher : voucherLists) {
			if(voucher.getId() == voucherId) {
				return voucher;
			}
		}
		
		return null;
	}

	@Override
	public int create(ShoppingCart cart, String customer) {
		
		var voucher = new Voucher();
		voucher.setCustomer(customer);
		voucher.setSales(cart.items());
		voucher.setSaleDateTime(LocalDateTime.now());
		voucher.setId(voucherLists.size() +1);
		
		voucherLists.add(voucher);
		
		return voucher.getId();
	}

}
