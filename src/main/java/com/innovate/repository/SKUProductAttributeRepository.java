package com.innovate.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.innovate.model.SKUProductAttribute;

@Repository
public interface SKUProductAttributeRepository extends CrudRepository<SKUProductAttribute, UUID> {

    // Custom method to find SKUProductAttribute by SKU ID
    List<SKUProductAttribute> findBySkuSkuId(UUID skuId);

    // Custom method to find SKUProductAttribute by attribute ID
    List<SKUProductAttribute> findByAttributeAttributeId(UUID attributeId);

    // Custom method to find SKUProductAttribute by attribute value ID
    List<SKUProductAttribute> findByAttributeValueAttributeValueId(UUID attributeValueId);

    // Custom query using @Query annotation
    @Query("SELECT spa FROM SKUProductAttribute spa WHERE spa.sku.product.shop.shopId = :shopId")
    List<SKUProductAttribute> findByShopId(UUID shopId);

    // Custom method to find SKUProductAttribute by SKU ID and attribute ID
    Optional<SKUProductAttribute> findBySkuSkuIdAndAttributeAttributeId(UUID skuId, UUID attributeId);
}
