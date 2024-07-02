package com.ganeshgc.aoppracticeprojecttutorial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private long id;
    private String productName;
    private double productPrice;
}
