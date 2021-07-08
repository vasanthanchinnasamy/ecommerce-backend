package com.innovate.service;

import com.innovate.model.Shop;

public interface ShopService {
	
	public Shop addShop(Shop shop);
	
	public Iterable<Shop> getShops();
	

}
