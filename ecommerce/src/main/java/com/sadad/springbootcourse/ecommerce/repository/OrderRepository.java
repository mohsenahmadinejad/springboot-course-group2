package com.sadad.springbootcourse.ecommerce.repository;

import com.sadad.springbootcourse.ecommerce.entity.Customer;
import com.sadad.springbootcourse.ecommerce.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {


}
