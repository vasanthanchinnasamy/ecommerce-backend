package com.innovate.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovate.dto.ShopDto;
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
	
	@PostMapping("/add")
	public ResponseEntity<Shop> add(@RequestBody ShopDto shopDto){
		return new ResponseEntity<>(shopService.addShop(shopDto.convertToShop(shopDto)),HttpStatus.OK);
	}

}
