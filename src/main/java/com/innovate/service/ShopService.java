package com.innovate.service;

import java.util.UUID;

import com.innovate.dto.ShopDto;
import com.innovate.model.Shop;

public interface ShopService {
	
	public Shop addShop(Shop shop);
	
	public Iterable<Shop> getShops();
	
	public void removeShop(UUID shopId);
	
	public Shop updateShop(ShopDto shopDto);
	

}
