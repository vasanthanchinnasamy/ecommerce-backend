package com.innovate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovate.model.SKUProductAttribute;
import com.innovate.repository.SKUProductAttributeRepository;

@Service
public class SKUProductAttributeServiceImpl implements SKUProductAttributeService {

    @Autowired
    private SKUProductAttributeRepository skuProductAttributeRepository;

    @Override
    public SKUProductAttribute addSKUProductAttribute(SKUProductAttribute skuProductAttribute) {
        return skuProductAttributeRepository.save(skuProductAttribute);
    }

    @Override
    public Iterable<SKUProductAttribute> getAllSKUProductAttributes() {
        return skuProductAttributeRepository.findAll();
    }

    @Override
    public void removeSKUProductAttribute(SKUProductAttribute skuProductAttribute) {
        skuProductAttributeRepository.delete(skuProductAttribute);
    }
}
