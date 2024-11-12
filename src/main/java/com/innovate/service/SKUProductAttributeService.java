package com.innovate.service;

import com.innovate.dto.SKUProductAttributeDto;
import com.innovate.model.SKU;
import com.innovate.model.SKUProductAttribute;

import java.util.UUID;

public interface SKUProductAttributeService {

    SKUProductAttribute addSKUProductAttribute(SKUProductAttributeDto skuProductAttributeDto);

    Iterable<SKUProductAttribute> getAllSKUProductAttributes();

    void removeSKUProductAttribute(SKUProductAttributeDto skuProductAttributeDto);

    Iterable<SKUProductAttribute> getSKUProductAttributesByProduct(UUID productId);
}
