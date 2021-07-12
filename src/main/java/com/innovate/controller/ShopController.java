package com.innovate.controller;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.innovate.dto.ShopDto;
import com.innovate.model.Product;
import com.innovate.model.Shop;
import com.innovate.service.ShopService;


@RestController
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	private ShopService shopService;
	
	@GetMapping("/getAll")
	public ResponseEntity<Iterable<Shop>> getAll(){
		return new ResponseEntity<>(shopService.getShops(),HttpStatus.OK);
	}
	
	@GetMapping("/get/{shopId}")
	public ResponseEntity<Shop> get(@PathVariable UUID shopId){
		return new ResponseEntity<>(shopService.get(shopId),HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Shop> add(@RequestBody ShopDto shopDto){
		return new ResponseEntity<>(shopService.addShop(shopDto.convertToShop(shopDto)),HttpStatus.OK);
	}
	
	@DeleteMapping("/remove")
	public ResponseEntity<Void> remove(@RequestParam UUID shopId){
		shopService.removeShop(shopId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Shop> update(@RequestBody ShopDto shopDto){
		return new ResponseEntity<>(shopService.updateShop(shopDto),HttpStatus.OK);
	}

}
