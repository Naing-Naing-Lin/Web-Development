package com.jdc.shop.model;

import java.util.List;

import com.jdc.shop.model.entity.Voucher;

public interface SaleModel {

	static SaleModel generate() {
		return new SaleModelImpl();
	}

	List<Voucher> getSaleHistory();

	Voucher findByVoucherId(int voucherId);

	int create(ShoppingCart cart, String customer);
}
