package com.innovate.service;

import com.innovate.dto.SKUProductAttributeDto;
import com.innovate.model.SKUProductAttribute;

public interface SKUProductAttributeService {

    SKUProductAttribute addSKUProductAttribute(SKUProductAttributeDto skuProductAttributeDto);

    Iterable<SKUProductAttribute> getAllSKUProductAttributes();

    void removeSKUProductAttribute(SKUProductAttributeDto skuProductAttributeDto);
}
