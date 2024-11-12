package com.innovate.service;

import com.innovate.dto.SKUProductAttributeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovate.model.SKUProductAttribute;
import com.innovate.repository.SKUProductAttributeRepository;

import java.util.List;
import java.util.UUID;

@Service
public class SKUProductAttributeServiceImpl implements SKUProductAttributeService {

    @Autowired
    private SKUProductAttributeRepository skuProductAttributeRepository;

    @Override
    public SKUProductAttribute addSKUProductAttribute(SKUProductAttributeDto skuProductAttributeDto) {
        return skuProductAttributeRepository.save(skuProductAttributeDto.toSKUProductAttribute());
    }

    @Override
    public Iterable<SKUProductAttribute> getAllSKUProductAttributes() {
        return skuProductAttributeRepository.findAll();
    }

    @Override
    public void removeSKUProductAttribute(SKUProductAttributeDto skuProductAttributeDto) {
        skuProductAttributeRepository.delete(skuProductAttributeDto.toSKUProductAttribute());
    }

    @Override
    public List<SKUProductAttribute> getSKUProductAttributesByProduct(UUID productId) {
        return skuProductAttributeRepository.findByProductId(productId);
    }
}
