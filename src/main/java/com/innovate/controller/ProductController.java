package com.innovate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovate.dto.ProductDto;
import com.innovate.dto.ShopDto;
import com.innovate.model.Product;
import com.innovate.model.Shop;
import com.innovate.service.ProductService;
import com.innovate.service.ShopService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/getAll")
	public ResponseEntity<Iterable<Product>> getAll(){
		return new ResponseEntity<>(productService.getProducts(),HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Product> add(@RequestBody ProductDto productDto){
		return new ResponseEntity<>(productService.addProduct(productDto.convertToProduct(productDto)),HttpStatus.OK);
	}

}
