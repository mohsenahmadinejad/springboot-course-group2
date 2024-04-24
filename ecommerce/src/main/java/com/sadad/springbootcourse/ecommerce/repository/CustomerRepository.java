package com.sadad.springbootcourse.ecommerce.repository;

import com.sadad.springbootcourse.ecommerce.entity.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    public List<Customer> findByFirstName(String firstName);
    public List<Customer> findByFirstNameAndLastName(String first, String lastName);
    public List<Customer> findByFirstNameContaining(String s);

    //JPQL
    @Query("select c from Customer  c where c.email=?1")
    public List<Customer> getCustomerByEmail(String email);

    //JPQL
    @Query("select c from Customer  c where c.firstName=:fistName and c.lastName=:lastName" )
    public List<Customer> getCustomerByFistNameAndLastName(@Param("fistName") String fistName,
            @Param("lastName") String lastName);


    //native
//    @Query("select c from Customer  c where c.email=?1")
    @Query(value = "select * from tbl_customer  c where c.email_address=?1",
            nativeQuery = true
    )
    public List<Customer> getCustomerByEmailNative(String email);


    @Transactional
    @Modifying
    @Query("update  Customer c set c.firstName=?1 where c.id =?2")
    public Integer updateFirstNameInCustomerByQuery(String firstName, Long id);

    public List<Customer> findByLastName(String lastName, Pageable page);


    @Query("select c from Customer c where c.lastName=?1")
    public List<Customer> getCustomerByLastNameQueryPagination(String lastName,Pageable pageable);

}
