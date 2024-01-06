package com.innovate.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.innovate.model.SKU;

@Repository
public interface SKURepository extends CrudRepository<SKU, UUID> {

    // Custom method to find SKUs by product ID
    List<SKU> findByProductProductId(UUID productId);

    // Custom method to find SKUs by SKU code
    Optional<SKU> findBySkuCode(String skuCode);

    // Custom method to find SKUs by price range
    List<SKU> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    // Custom method to find SKUs with low stock
    List<SKU> findByCurrentStockLessThan(Integer stockThreshold);

    // Custom query using @Query annotation
    @Query("SELECT s FROM SKU s WHERE s.product.shop.shopId = :shopId")
    List<SKU> findByShopId(UUID shopId);
}
