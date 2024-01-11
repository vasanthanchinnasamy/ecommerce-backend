package com.innovate.service;

import java.util.List;
import java.util.UUID;

import com.innovate.dto.ProductDto;
import com.innovate.entity.ProductInfo;
import com.innovate.model.Product;
import com.innovate.model.Shop;

public interface ProductService {
	
	public Product addProduct(Product product);
	
	public Iterable<Product> getProducts();
	
	public List<ProductInfo> getProductsByShopId(UUID shopId);
	
	public void removeProduct(UUID productId);
	
	public Product updateProduct(ProductDto productDto);

	public Product getProduct(UUID productId);

}
