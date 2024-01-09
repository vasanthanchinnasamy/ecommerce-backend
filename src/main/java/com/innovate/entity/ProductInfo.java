package com.innovate.entity;

import com.innovate.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfo {
    private Product product;
    private BigDecimal minPrice;
    private long numberOfSkus;
}

