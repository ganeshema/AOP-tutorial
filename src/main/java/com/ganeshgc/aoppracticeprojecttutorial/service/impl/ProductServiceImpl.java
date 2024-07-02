package com.ganeshgc.aoppracticeprojecttutorial.service.impl;

import com.ganeshgc.aoppracticeprojecttutorial.dto.ProductDto;
import com.ganeshgc.aoppracticeprojecttutorial.model.Product;
import com.ganeshgc.aoppracticeprojecttutorial.repository.ProductRepository;
import com.ganeshgc.aoppracticeprojecttutorial.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> findAllProducts() {
        List<ProductDto> productDtoList = new ArrayList<>();
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            productDtoList.add(productDto);
        }
        return productDtoList;
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        if (productDto == null) {
            throw new IllegalArgumentException("ProductDto cannot be null");
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        productRepository.save(product);

        return productDto;
    }
}
