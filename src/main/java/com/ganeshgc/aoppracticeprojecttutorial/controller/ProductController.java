package com.ganeshgc.aoppracticeprojecttutorial.controller;

import com.ganeshgc.aoppracticeprojecttutorial.dto.ProductDto;
import com.ganeshgc.aoppracticeprojecttutorial.model.Product;
import com.ganeshgc.aoppracticeprojecttutorial.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
       List<ProductDto> productDtoList= productService.findAllProducts();
        return new ResponseEntity(productDtoList, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto productDto) {
        ProductDto productDto1=productService.addProduct(productDto);
        return new ResponseEntity<>(productDto1, HttpStatus.CREATED);
    }
}
