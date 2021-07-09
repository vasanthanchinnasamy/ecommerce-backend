package com.innovate.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Product {
	
	@Id
	UUID productId;
	
	String productName;
	
	String productDescription;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shop_id")
	private Shop shop;

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Product(UUID productId, String productName, String productDescription) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
	}

	public Product() {
	}
	
	

}
