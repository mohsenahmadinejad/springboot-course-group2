package com.sadad.springbootcourse.ecommerce.repository;

import com.sadad.springbootcourse.ecommerce.entity.Order;
import com.sadad.springbootcourse.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {


}
