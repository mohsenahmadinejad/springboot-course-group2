package com.sadad.springbootcourse.ecommerce.repository;

import com.sadad.springbootcourse.ecommerce.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void saveProduct(){
        Product product= Product.builder()
                .unitPrice(10D)
                .productName("product1")
                .description("this is product1")
                .build();
        productRepository.save(product);
    }

}