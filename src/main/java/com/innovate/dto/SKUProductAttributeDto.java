package com.innovate.dto;

import com.innovate.model.ProductAttribute;
import com.innovate.model.ProductAttributeValue;
import com.innovate.model.SKU;
import com.innovate.model.SKUProductAttribute;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SKUProductAttributeDto {

    private UUID skuId;

    private UUID attributeId;

    private UUID attributeValueId;


    public SKUProductAttribute toSKUProductAttribute() {
        SKUProductAttribute skuProductAttribute = new SKUProductAttribute();

        skuProductAttribute.setSku(new SKU(skuId, null, null, null, null, null));
        skuProductAttribute.setAttribute(new ProductAttribute(attributeId, null));
        skuProductAttribute.setAttributeValue(new ProductAttributeValue(attributeValueId, null, null));

        return skuProductAttribute;
    }
}
