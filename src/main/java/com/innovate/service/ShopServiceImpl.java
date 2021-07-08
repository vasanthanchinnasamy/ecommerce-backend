package com.innovate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovate.model.Shop;
import com.innovate.repository.ShopRepository;

@Service
public class ShopServiceImpl implements ShopService{
	
	@Autowired
	private ShopRepository shopRepository;

	@Override
	public Shop addShop(Shop shop) {
		return shopRepository.save(shop);
	}

	@Override
	public Iterable<Shop> getShops() {
		return shopRepository.findAll();
	}


}
