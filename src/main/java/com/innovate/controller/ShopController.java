package com.innovate.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/shop")
public class ShopController {
	
	@GetMapping("/getAll")
	public String bulkcreate(){
		return "check";
	}

}
