package com.innovate.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovate.dto.ShopDto;
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

	@Override
	public void removeShop(UUID shopId) {
		Shop deleteShop = new Shop();
		deleteShop.setShopId(shopId);
		shopRepository.delete(deleteShop);
	}

	@Override
	public Shop updateShop(ShopDto shopDto) {
		Shop deleteShop = new Shop(shopDto.getShopId(), shopDto.getShopName(), shopDto.getShopDescription());
		return shopRepository.save(deleteShop);
	}

	@Override
	public Shop get(UUID shopId) {
		return shopRepository.findById(shopId).orElseGet(null);
	}
}
