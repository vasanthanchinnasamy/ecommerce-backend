package com.innovate.service;

import java.util.UUID;

import com.innovate.dto.SKUDto;
import com.innovate.model.SKU;

public interface SKUService {

    SKU addSKU(SKUDto sku);

    Iterable<SKU> getAllSKUs();

    Iterable<SKU> getSKUsByProduct(UUID productId);

    void removeSKU(UUID skuId);

    SKU updateSKU(SKUDto skuDto);
}
