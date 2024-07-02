package com.ganeshgc.aoppracticeprojecttutorial.service;

import com.ganeshgc.aoppracticeprojecttutorial.dto.ProductDto;
import com.ganeshgc.aoppracticeprojecttutorial.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<ProductDto> findAllProducts();
    ProductDto addProduct(ProductDto productDto);
}
