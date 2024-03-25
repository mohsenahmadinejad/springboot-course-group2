package com.sadad.springbootcourse.ecommerce.service;


import com.sadad.springbootcourse.ecommerce.entity.*;
import com.sadad.springbootcourse.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private CustomerActivityService customerActivityService;


    public List<Order> findAll() {
        List<Order> orderList = orderRepository.findAll();
        return orderList;
    }


    public Order get(Long id) {
        return orderRepository.findById(id).get();
    }


    public Order save(Order order) throws Exception {
        return orderRepository.save(order);
    }

    public Order createSampleOrder(){
        Customer customer=new Customer();
        customer.setId(65L);
//
//        CustomerActivity customerActivity= CustomerActivity.builder()
//                .activityDate(LocalDateTime.now())
//                .description("create an order")
//                .build();

        Order order= Order.builder()
                .orderDate(LocalDateTime.now())
                .totalAmount(300D)
                .customer(customer)
                .build();

        Product product1=new Product();
        product1.setId(1L);

        Product product2=new Product();
        product2.setId(2L);

        OrderItem orderItem1= OrderItem.builder()
                .productName("product1")
                .price(10D)
                .quantity(2)
                .order(order)
                .product(product1)
                .build();


        OrderItem orderItem2= OrderItem.builder()
                .productName("product2")
                .price(10D)
                .quantity(5)
                .order(order)
                .product(product2)
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
        return order;

    }

    @Transactional( propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Order saveOrderWithCustomerActivityLog(Order order) throws Exception {

//begin transactionm

        customerActivityService.saveWithMessage(65L,"Start order");


        if (order==null ) {
            order = createSampleOrder();
        }
        processOrder(order);
        order.setStatus("completed");
        Order savedOrder =orderRepository.save(order);

        customerActivityService.saveWithMessage(65L,"Finish order");
        return savedOrder;
        //end transaction
    }

    //  @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void processOrder(Order order) throws Exception {
        for (OrderItem orderItem : order.getOrderItems()) {
            Product product = orderItem.getProduct();
            int quantityOrdered = orderItem.getQuantity();
            inventoryService.deductInventory(product, quantityOrdered);

        }
    }




}
