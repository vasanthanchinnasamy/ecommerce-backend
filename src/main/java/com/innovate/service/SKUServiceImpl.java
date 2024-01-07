package com.innovate.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovate.dto.SKUDto;
import com.innovate.model.SKU;
import com.innovate.repository.SKURepository;

@Service
public class SKUServiceImpl implements SKUService {

    @Autowired
    private SKURepository skuRepository;

    @Override
    public SKU addSKU(SKUDto skuDto) {
        return skuRepository.save(skuDto.toSKU());
    }

    @Override
    public Iterable<SKU> getAllSKUs() {
        return skuRepository.findAll();
    }

    @Override
    public Iterable<SKU> getSKUsByProduct(UUID productId) {
        return skuRepository.findByProductProductId(productId);
    }

    @Override
    public void removeSKU(UUID skuId) {
        skuRepository.deleteById(skuId);
    }

    @Override
    public SKU updateSKU(SKUDto skuDto) {
        SKU sku = skuDto.toSKU();
        return skuRepository.save(sku);
    }
}
