package com.sadad.springbootcourse.ecommerce.repository;

import com.sadad.springbootcourse.ecommerce.entity.*;
import com.sadad.springbootcourse.ecommerce.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderRepositoryTest {


    @Autowired
    private OrderRepository orderRepository;


    @Autowired
    private OrderService orderService;

    @Test
    void saveOrder() {
//        Order order = new Order(null, LocalDateTime.now(), 100D, null,null);
        Customer customer=new Customer();
        customer.setId(65L);



        Order order= Order.builder()
                .orderDate(LocalDateTime.now())
                .totalAmount(300D)
                .customer(customer)
                .build();

        Product product=new Product();
        product.setId(1L);

        OrderItem orderItem1= OrderItem.builder()
                .productName("product1")
                .price(10D)
                .quantity(1)
                .order(order)
                .product(product)
                .build();


        OrderItem orderItem2= OrderItem.builder()
                .productName("product2")
                .price(10D)
                .quantity(1)
                .order(order)
                .product(product)
                  .build();

        ShippingAddress shippingAddress= ShippingAddress.builder()
                .city("Tehran")
                .state("Tehran")
                .zipCode("123456")
                .street("Valiasr")
                .order(order)
                .build();


        List<OrderItem> orderItemList=new ArrayList<>();
        orderItemList.add(orderItem1);
        orderItemList.add(orderItem2);
        order.setOrderItems(new ArrayList<>());
        order.setOrderItems(orderItemList);

        order.setShippingAddress(shippingAddress);







        orderRepository.save(order);
    }

    @Test
    void saveOrderWithCustomerActivityLog() throws Exception {

        orderService.saveOrderWithCustomerActivityLog(null);

    }
}