package com.innovate.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.innovate.model.ProductAttribute;

@Repository
public interface ProductAttributeRepository extends CrudRepository<ProductAttribute, UUID> {

    // Custom method to find product attributes by name
    List<ProductAttribute> findByAttributeName(String attributeName);

    // Custom method to find product attributes by partial name match
    List<ProductAttribute> findByAttributeNameContaining(String partialAttributeName);

//    // Custom method to find product attributes by category
//    List<ProductAttribute> findByCategory(String category);
//
//    // Custom query using @Query annotation
//    @Query("SELECT pa FROM ProductAttribute pa WHERE pa.category = :category AND pa.active = true")
//    List<ProductAttribute> findByCategoryAndActiveIsTrue(String category);

    // Custom method to find product attribute by ID and name
    Optional<ProductAttribute> findByAttributeIdAndAttributeName(UUID attributeId, String attributeName);
}
