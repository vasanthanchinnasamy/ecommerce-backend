package com.innovate.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Shop {
	
	@Id
	UUID shopId;
	
	String shopName;
	
	String shopDescription;
	
	@JsonBackReference(value="productListRef")
	@OneToMany(
            mappedBy = "shop",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
	List<Product> productList;

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
