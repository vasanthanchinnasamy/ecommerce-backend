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
	public Iterable<Product> getProducts(UUID shopId) {
		return productRepository.findByShopShopId(shopId);
	}

	@Override
	public void removeProduct(UUID productId) {
		Product deleteProduct = new Product();
		deleteProduct.setProductId(productId);
		productRepository.delete(deleteProduct);
	}

	@Override
	public Product updateProduct(ProductDto productDto) {
		Product product = new Product(productDto.getProductId(), productDto.getProductName(), productDto.getProductDescription());
		Shop shop = new Shop();
		shop.setShopId(productDto.getShopId());
		product.setShop(shop);
		return productRepository.save(product);
	}



}
