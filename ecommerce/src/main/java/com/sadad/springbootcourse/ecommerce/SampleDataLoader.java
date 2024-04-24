package com.sadad.springbootcourse.ecommerce;

import com.github.javafaker.Faker;

import com.sadad.springbootcourse.ecommerce.entity.Customer;
import com.sadad.springbootcourse.ecommerce.entity.Order;
import com.sadad.springbootcourse.ecommerce.entity.OrderItem;
import com.sadad.springbootcourse.ecommerce.entity.Product;
import com.sadad.springbootcourse.ecommerce.repository.CustomerRepository;
import com.sadad.springbootcourse.ecommerce.repository.OrderItemRepository;
import com.sadad.springbootcourse.ecommerce.repository.OrderRepository;
import com.sadad.springbootcourse.ecommerce.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@Slf4j
public class SampleDataLoader implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductRepository productRepository;


//    @Autowired
//    private Faker faker;

//    @Value("${database.stock-table.create-sample-data.status}")
//    private String createSampleDataStatus;
//
//    @Value("${database.stock-table.create-sample-data.row-count}")
//    private String createSampleDataRowCount;


    public static LocalDateTime convertToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    public  Date convertToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    @Override
    public void run(String... args) throws Exception {
//        if (createSampleDataStatus.equalsIgnoreCase("off")){
//            return;
//        }
        if(1==1) {
           return;
        }

         Faker faker=new Faker();

        log.info("Loading Sample Data...");

        List<Customer> customerList= IntStream.rangeClosed(1,Integer.parseInt("100"))
            .mapToObj(i-> Customer.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .build()
            ).collect(Collectors.toList());

        customerRepository.saveAll(customerList);


        List<Product> productList= IntStream.rangeClosed(1,Integer.parseInt("10"))
            .mapToObj(i-> Product.builder()
                .productName(faker.commerce().productName())
                .unitPrice(new Random().nextDouble(10000))
                .description( faker.lorem().sentence())
                .build()
            ).collect(Collectors.toList());

        productRepository.saveAll(productList);


        List<Order> orderList= IntStream.rangeClosed(1,Integer.parseInt("100"))
            .mapToObj(i-> Order.builder()
                .orderDate(convertToLocalDateTime(faker.date().between(convertToDate(LocalDate.now().minusYears(1)),new Date())))
                .totalAmount(new Random().nextDouble(1000))
                .customer(Customer.builder().id(new Random().nextLong(99)+1).build())
                .build()
            ).collect(Collectors.toList());

        orderRepository.saveAll(orderList);

        List<OrderItem> orderItemList= IntStream.rangeClosed(1,Integer.parseInt("300"))
            .mapToObj(i-> OrderItem.builder()
                .order(Order.builder().id(new Random().nextLong(99)+1).build())
                .product(Product.builder().id(new Random().nextLong(9)+1).build())
                .price(new Random().nextDouble(10000))
                .quantity(new Random().nextInt(5))
                .build()
            ).collect(Collectors.toList());

        orderItemRepository.saveAll(orderItemList);
    }
}
