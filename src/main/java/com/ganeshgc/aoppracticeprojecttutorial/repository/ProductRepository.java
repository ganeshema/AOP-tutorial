package com.ganeshgc.aoppracticeprojecttutorial.repository;

import com.ganeshgc.aoppracticeprojecttutorial.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
