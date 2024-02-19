package com.sadad.springbootcourse.ecommerce.service;




import com.sadad.springbootcourse.ecommerce.entity.Customer;
import com.sadad.springbootcourse.ecommerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CustomerService {


    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> findAll() {

        return customerRepository.findAll();
    }

    public Customer get(Long id) {
       return customerRepository.findById(id).get();

    }

    public Long create(Customer customer) {

        return customerRepository.save(customer).getId();
    }






}
