package com.innovate.dto;

import java.util.UUID;

import javax.validation.constraints.NotEmpty;

import com.innovate.model.Product;

public class ProductDto {
	
	@NotEmpty(message = "Product name must not be empty")
	String productName;
	
	String productDescription;

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

	public ProductDto(@NotEmpty(message = "Product name must not be empty") String productName,
			String productDescription) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
	}

	public ProductDto() {}

	public Product convertToProduct(ProductDto productDto) {
		return new Product(UUID.randomUUID(), productDto.getProductName(), productDto.getProductDescription());
	}
	
	

}
