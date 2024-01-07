package com.innovate.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovate.dto.ProductAttributeValueDto;
import com.innovate.model.ProductAttributeValue;
import com.innovate.repository.ProductAttributeValueRepository;

@Service
public class ProductAttributeValueServiceImpl implements ProductAttributeValueService {

    @Autowired
    private ProductAttributeValueRepository productAttributeValueRepository;

    @Override
    public ProductAttributeValue addProductAttributeValue(ProductAttributeValueDto productAttributeValue) {
        return productAttributeValueRepository.save(productAttributeValue.toProductAttributeValue());
    }

    @Override
    public Iterable<ProductAttributeValue> getProductAttributeValues() {
        return productAttributeValueRepository.findAll();
    }

    @Override
    public Iterable<ProductAttributeValue> getProductAttributeValuesByAttribute(UUID attributeId) {
        // Implement your logic to fetch product attribute values by attribute ID
        // For example: productAttributeValueRepository.findByAttributeId(attributeId);
        return productAttributeValueRepository.findByAttributeAttributeId(attributeId);
    }

    @Override
    public void removeProductAttributeValue(UUID attributeValueId) {
        productAttributeValueRepository.deleteById(attributeValueId);
    }

    @Override
    public ProductAttributeValue updateProductAttributeValue(ProductAttributeValueDto productAttributeValueDto) {
        ProductAttributeValue productAttributeValue = productAttributeValueDto.toProductAttributeValue();
        return productAttributeValueRepository.save(productAttributeValue);
    }
}
