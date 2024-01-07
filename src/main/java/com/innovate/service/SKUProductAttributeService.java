package com.innovate.service;

import com.innovate.model.SKUProductAttribute;

public interface SKUProductAttributeService {

    SKUProductAttribute addSKUProductAttribute(SKUProductAttribute skuProductAttribute);

    Iterable<SKUProductAttribute> getAllSKUProductAttributes();

    void removeSKUProductAttribute(SKUProductAttribute skuProductAttribute);
}
