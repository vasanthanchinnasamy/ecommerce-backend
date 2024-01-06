package com.innovate.dto;

import com.innovate.model.Product;
import com.innovate.model.SKU;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SKUDto {

    private UUID skuId;

    private UUID productId;

    private BigDecimal price;

    private Integer currentStock;

    @NotEmpty(message = "SKU code must not be empty")
    private String skuCode;

    private String image;

    public SKUDto(UUID productId, BigDecimal price, Integer currentStock, String skuCode, String image) {
        this.productId = productId;
        this.price = price;
        this.currentStock = currentStock;
        this.skuCode = skuCode;
        this.image = image;
    }

    public SKU toSKU() {
        SKU sku = new SKU();
        sku.setSkuId(this.skuId);

        sku.setProduct(new Product(this.productId, null, null));

        sku.setPrice(this.price);
        sku.setCurrentStock(this.currentStock);
        sku.setSkuCode(this.skuCode);
        sku.setImage(this.image);
        return sku;
    }
}
