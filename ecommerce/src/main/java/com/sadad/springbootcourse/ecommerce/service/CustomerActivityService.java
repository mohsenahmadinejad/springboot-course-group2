package com.sadad.springbootcourse.ecommerce.service;




import com.sadad.springbootcourse.ecommerce.entity.Customer;
import com.sadad.springbootcourse.ecommerce.entity.CustomerActivity;
import com.sadad.springbootcourse.ecommerce.repository.CustomerActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class CustomerActivityService {

    @Autowired
    private CustomerActivityRepository repository;




    public List<CustomerActivity> findAll() {
        List<CustomerActivity> customerActivities = repository.findAll();
        return customerActivities;
    }

    @Transactional
    public CustomerActivity getById(Long id) {
        return repository.findById(id).get();

    }

    public Long save(CustomerActivity customerActivity) {
        return repository.save(customerActivity).getId();
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveWithMessage(Long CustomerId,String description) {
        Customer customer=new Customer();
        customer.setId(CustomerId);

        CustomerActivity customerActivity= CustomerActivity.builder()
                .activityDate(LocalDateTime.now())
                .description(description)
                .customer(customer)
                .build();

        save(customerActivity);
    }


}
