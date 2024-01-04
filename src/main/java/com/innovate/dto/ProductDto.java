package com.innovate.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import com.innovate.model.Product;
import com.innovate.model.Shop;

public class ProductDto {
	
	UUID productId;	
	
	@NotEmpty(message = "shopId name must not be empty")
	@NotNull(message = "shopId name must not be null")
	UUID shopId;
	
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
	
	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}
	

	public UUID getShopId() {
		return shopId;
	}

	public void setShopId(UUID shopId) {
		this.shopId = shopId;
	}

	public ProductDto() {}

	public Product convertToProduct(ProductDto productDto) {
		Product convertedProduct = new Product(UUID.randomUUID(), productDto.getProductName(), productDto.getProductDescription());
		Shop shop = new Shop();
		shop.setShopId(productDto.getShopId());
		convertedProduct.setShop(shop);
		return convertedProduct;
	}
	
	

}
