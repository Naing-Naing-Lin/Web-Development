package com.jdc.shop.model;

import java.util.List;

import com.jdc.shop.model.entity.Voucher;

public interface SaleModel {

	public static SaleModel generate() {
		return new SaleModelImpl();
	}

	public List<Voucher> getSaleHistory();
}
