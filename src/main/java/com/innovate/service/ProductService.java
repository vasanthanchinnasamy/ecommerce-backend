package com.innovate.service;

import com.innovate.model.Product;

public interface ProductService {
	
	public Product addProduct(Product product);
	
	public Iterable<Product> getProducts();

}
