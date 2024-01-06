package com.innovate.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.innovate.model.ProductAttributeValue;

@Repository
public interface ProductAttributeValueRepository extends CrudRepository<ProductAttributeValue, UUID> {

    // Custom method to find product attribute values by name
    List<ProductAttributeValue> findByAttributeValueName(String attributeValueName);

    // Custom method to find product attribute values by partial name match
    List<ProductAttributeValue> findByAttributeValueNameContaining(String partialAttributeValueName);

    // Custom method to find product attribute values by attribute
    List<ProductAttributeValue> findByAttributeAttributeId(UUID attributeId);

//    // Custom query using @Query annotation
//    @Query("SELECT pav FROM ProductAttributeValue pav WHERE pav.attribute.attributeId = :attributeId AND pav.active = true")
//    List<ProductAttributeValue> findByAttributeIdAndActiveIsTrue(UUID attributeId);

    // Custom method to find product attribute value by ID and name
    Optional<ProductAttributeValue> findByAttributeValueIdAndAttributeValueName(UUID attributeValueId, String attributeValueName);
}
