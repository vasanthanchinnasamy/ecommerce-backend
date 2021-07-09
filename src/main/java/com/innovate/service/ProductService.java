package com.innovate.service;

import java.util.UUID;

import com.innovate.dto.ProductDto;
import com.innovate.model.Product;

public interface ProductService {
	
	public Product addProduct(Product product);
	
	public Iterable<Product> getProducts();
	
	public void removeProduct(UUID productId);
	
	public Product updateProduct(ProductDto productDto);

}
