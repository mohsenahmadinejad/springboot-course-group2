package com.sadad.springbootcourse.ecommerce;

import com.sadad.springbootcourse.ecommerce.entity.Customer;
import com.sadad.springbootcourse.ecommerce.entity.Order;
import com.sadad.springbootcourse.ecommerce.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CustomerTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void saveCustomer() {
        Customer customer=new Customer(null,"Mohsen","ahmadi","mohsen@gmail.com",null);
//        Customer customer=Customer.builder().
//                firstName("mohsen").
//                lastName("ahmadi").
//                email("mohsen@gmail.com").
//                build();
        customerRepository.save(customer);
    }


    @Test
    void updateCustomer() {
        Customer customer=new Customer(40L,"Ali40","mohammadi40","ali40@gmail.com",null);
        customerRepository.save(customer);
    }

    @Test
    void findCustomerById() {
        Customer customer= customerRepository.findById(5L).get();
        System.out.println(customer);
    }
    @Test
    void findAllCustomerById() {
        List< Customer> customers= customerRepository.findAll();
        customers.forEach(customer -> System.out.println(customer));
    }
    @Test
    void deleteCustomer() {
        customerRepository.deleteById(5L);
    }

    @Test
    void findByFirstName() {
        List<Customer> customers= customerRepository.findByFirstName("Ali");
        customers.forEach(customer -> System.out.println(customer));
    }

    @Test
    void findByFirstNameAndLastName() {
        List<Customer> customers= customerRepository.findByFirstNameAndLastName("Ali","Johnson");
        customers.forEach(customer -> System.out.println(customer));
    }
    @Test
    void findByFirstNameContaining() {
        List<Customer> customers= customerRepository.findByFirstNameContaining("m");
        customers.forEach(customer -> System.out.println(customer));
    }
    @Test
    void getCustomerByEmail() {
        List<Customer> customers= customerRepository.getCustomerByEmail("david.martinez@example.com");
        customers.forEach(customer -> System.out.println(customer));
    }

    @Test
    void getCustomerByFistNameAndLastName() {
        List<Customer> customers= customerRepository.getCustomerByFistNameAndLastName("ali","mohammadi");
        customers.forEach(customer -> System.out.println(customer));
    }


    @Test
    void getCustomerByEmailNative() {
        List<Customer> customers= customerRepository.getCustomerByEmailNative("david.martinez@example.com");
        customers.forEach(customer -> System.out.println(customer));
    }

    @Test
    void updateFirstNameInCustomerByQuery() {
        Integer updatedRowCount = customerRepository.updateFirstNameInCustomerByQuery("Reza",10L);
        System.out.println("rows updated =" +updatedRowCount);
    }

    @Test
    void saveCustomerWithOrders() {
        Order order1= Order.builder()
                .orderDate(LocalDateTime.now())
                .totalAmount(10D)
                .build();
        Order order2= Order.builder()
                .orderDate(LocalDateTime.now())
                .totalAmount(11D)
                .build();
        List<Order> orderList=new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);



        Customer customer= Customer.builder()
                .email("mohsen@gmail")
                .firstName("mohsen")
                .lastName("ahmadi")
                .orders(orderList)
                .build();

        order1.setCustomer(customer);
        order2.setCustomer(customer);

        customerRepository.save(customer);

    }

    @Test
    @Transactional
    void getCustomerById() {
        Customer customer=customerRepository.findById(65L).get();
        System.out.println(customer.getOrders());

    }

}
