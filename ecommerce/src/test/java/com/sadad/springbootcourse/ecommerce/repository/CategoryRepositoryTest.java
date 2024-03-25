package com.sadad.springbootcourse.ecommerce.repository;

import com.sadad.springbootcourse.ecommerce.entity.Category;
import com.sadad.springbootcourse.ecommerce.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository repository;

    @Test
    void saveCategory(){

        Product product2= Product.builder()
                .unitPrice(10D)
                .productName("product2")
                .description("this is product2")
                .build();

        Product product3= Product.builder()
                .unitPrice(10D)
                .productName("product3")
                .description("this is product3")
                .build();

        List<Product> productList=new ArrayList<>();
        productList.add(product2);
        productList.add(product3);

        Category category= Category.builder()
                .categoryName("category1")
                .products(productList)
                .build();

        repository.save(category);

    }

}