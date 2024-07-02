package com.ganeshgc.aoppracticeprojecttutorial.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="product_details")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long productId;
    @Column(name="product_name")
    private String productName;
    @Column(name="product_price")
    private double productPrice;
}
