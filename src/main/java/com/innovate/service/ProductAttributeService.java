package com.innovate.service;

import java.util.UUID;

import com.innovate.dto.ProductAttributeDto;
import com.innovate.model.ProductAttribute;

public interface ProductAttributeService {

    ProductAttribute addProductAttribute(ProductAttributeDto productAttributeDto);

    Iterable<ProductAttribute> getProductAttributes();

//    Iterable<ProductAttribute> getProductAttributesByCategory(String category);

    void removeProductAttribute(UUID attributeId);

    ProductAttribute updateProductAttribute(ProductAttributeDto productAttributeDto);
}
