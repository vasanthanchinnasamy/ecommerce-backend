package com.innovate.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.innovate.model.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product,UUID>{

}
