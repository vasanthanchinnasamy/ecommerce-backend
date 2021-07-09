package com.innovate.dto;

import java.util.UUID;

import javax.validation.constraints.NotEmpty;

import com.innovate.model.Shop;

public class ShopDto {
	
	UUID shopId;
	
	@NotEmpty(message = "Shop name must not be empty")
	String shopName;
	
	String shopDescription;
	
	public String getShopName() {
		return shopName;
	}


	public void setShopName(String shopName) {
		this.shopName = shopName;
	}


	public String getShopDescription() {
		return shopDescription;
	}

	public void setShopDescription(String shopDescription) {
		this.shopDescription = shopDescription;
	}
	
	

	public UUID getShopId() {
		return shopId;
	}


	public void setShopId(UUID shopId) {
		this.shopId = shopId;
	}


	public Shop convertToShop(ShopDto shopDto) {
		return new Shop(UUID.randomUUID(),shopDto.getShopName(),shopDto.getShopDescription());
	}

}
