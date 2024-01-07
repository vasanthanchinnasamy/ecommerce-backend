package com.innovate.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovate.dto.ProductDto;
import com.innovate.model.Product;
import com.innovate.model.Shop;
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
	
	@Override
	public Iterable<Product> getProductsByShopId(UUID shopId) {
		return productRepository.findByShopShopId(shopId);
	}

	@Override
	public void removeProduct(UUID productId) {
		productRepository.deleteById(productId);
	}

	@Override
	public Product updateProduct(ProductDto productDto) {
		Product product = productDto.convertToProduct(false);
		return productRepository.save(product);
	}



}
