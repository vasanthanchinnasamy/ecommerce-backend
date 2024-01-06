package com.innovate.dto;

import com.innovate.model.ProductAttribute;
import com.innovate.model.ProductAttributeValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductAttributeValueDto {

    private UUID attributeValueId;

    private UUID attributeId;

    @NotEmpty(message = "Attribute value name must not be empty")
    private String attributeValueName;

    public ProductAttributeValue toProductAttributeValue() {
        ProductAttributeValue productAttributeValue = new ProductAttributeValue();
        productAttributeValue.setAttributeValueId(this.attributeValueId);
        productAttributeValue.setAttributeValueName(this.attributeValueName);

        productAttributeValue.setAttribute(new ProductAttribute(this.attributeId, null));
        return productAttributeValue;
    }
}
