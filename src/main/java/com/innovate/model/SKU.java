package com.innovate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sku")
public class SKU {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID skuId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "current_stock")
    private Integer currentStock;

    @Column(name = "sku_code")
    private String skuCode;

    @Column(name = "image")
    private String image;
}
