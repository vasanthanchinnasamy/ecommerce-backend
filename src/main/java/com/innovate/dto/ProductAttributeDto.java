package com.innovate.dto;

import com.innovate.model.ProductAttribute;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductAttributeDto {

    private UUID attributeId;

    @NotEmpty(message = "Attribute name must not be empty")
    private String attributeName;

    public ProductAttribute toProductAttribute() {
        ProductAttribute productAttribute = new ProductAttribute();
        productAttribute.setAttributeId(this.attributeId);
        productAttribute.setAttributeName(this.attributeName);
        return productAttribute;
    }
}
