package com.innovate.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Product {
	
	@Id
	UUID productId;
	
	String productName;
	
	String productDescription;

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

	public Product(UUID productId, String productName, String productDescription) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
	}

	public Product() {
	}
	
	

}
