package com.innovate.repository;

import com.innovate.model.Order;
import com.innovate.model.OrderKey;
import com.innovate.model.ProductAttribute;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<Order, OrderKey> {
}
