package com.innovate.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Shop {
	
	@Id
	UUID shopId;
	
	String shopName;
	
	String shopDescription;

	public Shop(UUID shopId, String shopName, String productDescription) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
		this.shopDescription = productDescription;
	}
	
	public Shop() {}

	public UUID getShopId() {
		return shopId;
	}

	public void setShopId(UUID shopId) {
		this.shopId = shopId;
	}

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
	
	

}
