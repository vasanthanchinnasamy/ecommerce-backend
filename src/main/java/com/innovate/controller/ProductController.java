package com.innovate.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.innovate.dto.ProductDto;
import com.innovate.model.Product;
import com.innovate.service.ProductService;

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
	
	@DeleteMapping("/remove")
	public ResponseEntity<Void> remove(@RequestParam UUID productId){
		productService.removeProduct(productId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Product> update(@RequestBody ProductDto productDto){
		return new ResponseEntity<>(productService.updateProduct(productDto),HttpStatus.OK);
	}

}
