package com.innovate.service;

import java.util.UUID;

import com.innovate.dto.ProductAttributeValueDto;
import com.innovate.model.ProductAttributeValue;

public interface ProductAttributeValueService {

    ProductAttributeValue addProductAttributeValue(ProductAttributeValueDto productAttributeValue);

    Iterable<ProductAttributeValue> getProductAttributeValues();

    Iterable<ProductAttributeValue> getProductAttributeValuesByAttribute(UUID attributeId);

    void removeProductAttributeValue(UUID attributeValueId);

    ProductAttributeValue updateProductAttributeValue(ProductAttributeValueDto productAttributeValueDto);
}
