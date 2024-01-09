package com.innovate.repository;

import java.util.List;
import java.util.UUID;

import com.innovate.entity.ProductInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.innovate.model.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product,UUID>{
	
	public List<Product> findByShopShopId(UUID shopId);

	@Query("SELECT new com.innovate.entity.ProductInfo(p, MIN(s.price), COUNT(s)) " +
			"FROM Product p " +
			"LEFT JOIN p.skus s " +
			"WHERE p.shop.shopId = :shopId " +
			"GROUP BY p.productId")
	List<ProductInfo> findProductsWithMinPriceAndCountByShopId(@Param("shopId") UUID shopId);


}
