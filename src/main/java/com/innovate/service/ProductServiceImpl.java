package com.innovate.service;

import java.util.List;
import java.util.UUID;

import com.innovate.entity.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovate.dto.ProductDto;
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
	
	@Override
	public List<ProductInfo> getProductsByShopId(UUID shopId) {
		List<ProductInfo> productList = productRepository.findProductsWithMinPriceAndCountByShopId(shopId);
		return productList;
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

	@Override
	public Product getProduct(UUID productId) {
		return productRepository.findById(productId).orElseGet(null);
	}


}
