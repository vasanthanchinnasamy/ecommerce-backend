package com.innovate.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovate.dto.ProductAttributeDto;
import com.innovate.model.ProductAttribute;
import com.innovate.repository.ProductAttributeRepository;

@Service
public class ProductAttributeServiceImpl implements ProductAttributeService {

    @Autowired
    private ProductAttributeRepository productAttributeRepository;

    @Override
    public ProductAttribute addProductAttribute(ProductAttributeDto productAttributeDto) {
        return productAttributeRepository.save(productAttributeDto.toProductAttribute());
    }

    @Override
    public Iterable<ProductAttribute> getProductAttributes() {
        return productAttributeRepository.findAll();
    }

//    @Override
//    public Iterable<ProductAttribute> getProductAttributesByCategory(String category) {
//        // Implement your logic to fetch product attributes by category
//        // For example: productAttributeRepository.findByCategory(category);
//        return productAttributeRepository.findByCategory(category);
//    }

    @Override
    public void removeProductAttribute(UUID attributeId) {
        productAttributeRepository.deleteById(attributeId);
    }

    @Override
    public ProductAttribute updateProductAttribute(ProductAttributeDto productAttributeDto) {
        ProductAttribute productAttribute = new ProductAttribute(
                productAttributeDto.getAttributeId(),
                productAttributeDto.getAttributeName()
        );
        return productAttributeRepository.save(productAttribute);
    }
}
