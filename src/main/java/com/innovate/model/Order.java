package com.innovate.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_sample")
public class Order {

    @EmbeddedId
    private OrderKey orderKey;

    public Order(Long caseTid, Long tagId) {
        this.orderKey = new OrderKey(caseTid, tagId);
    }

}
