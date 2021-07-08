package com.innovate.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.innovate.model.Shop;

@Repository
public interface ShopRepository extends CrudRepository<Shop,UUID>{
	
	

}
