package com.innovate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovate.model.Product;
import com.innovate.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Iterable<Product> getProducts() {
		return productRepository.findAll();
	}

}
