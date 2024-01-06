package com.innovate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_attribute_value", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "attribute_id", "attribute_value_name" }) })
public class ProductAttributeValue {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID attributeValueId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "attribute_id")
    private ProductAttribute attribute;

    @Column(name = "attribute_value_name")
    private String attributeValueName;
}
