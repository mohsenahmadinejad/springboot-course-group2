package com.sadad.springbootcourse.ecommerce.repository;

import com.sadad.springbootcourse.ecommerce.entity.Category;
import com.sadad.springbootcourse.ecommerce.entity.Inventory;
import com.sadad.springbootcourse.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    public Inventory findByProduct(Product product);


}
