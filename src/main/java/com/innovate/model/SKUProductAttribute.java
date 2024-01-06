package com.innovate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sku_product_attribute",
        uniqueConstraints = @UniqueConstraint(columnNames = { "sku_id", "attribute_id", "attribute_value_id" }))
@IdClass(SKUProductAttribute.SKUProductAttributeId.class)
public class SKUProductAttribute {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sku_id")
    private SKU sku;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "attribute_id")
    private ProductAttribute attribute;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "attribute_value_id")
    private ProductAttributeValue attributeValue;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SKUProductAttributeId implements Serializable {
        private UUID sku;
        private UUID attribute;
        private UUID attributeValue;
    }
}
