package com.innovate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_attribute")
public class ProductAttribute {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID attributeId;

    private String attributeName;
}
