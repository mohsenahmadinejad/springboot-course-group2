package com.sadad.springbootcourse.ecommerce.rest;



import com.sadad.springbootcourse.ecommerce.entity.Customer;
import com.sadad.springbootcourse.ecommerce.repository.CustomerRepository;
import com.sadad.springbootcourse.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/api/customers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;


    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable(name = "id")  Long id) {
        return ResponseEntity.ok(customerService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createCustomer(@RequestBody  Customer customer) {
        final Long createdId = customerService.create(customer);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }


    @GetMapping("/sorted-by-field") ///sort?fieldName=lastName
    public ResponseEntity<List<Customer>> getAllCustomerSortedByField(@RequestParam String fieldName) {
        //Sort sort = Sort.by(fieldName);
        Sort sort = Sort.by(Sort.Direction.ASC, fieldName);
        //return ResponseEntity.ok(customerRepository.findAll(Sort.by(Sort.Direction.ASC,lastName)));
        return ResponseEntity.ok(customerRepository.findAll(sort));
    }

    @GetMapping("/sorted-by-fields") ///sorted-by-fields?fieldNames=lastName,firstName
    public ResponseEntity<List<Customer>> getAllCustomerSortedByFields(@RequestParam List<String> fieldNames ) {
        Sort sort = Sort.by(fieldNames.toArray(new String[0]));
        return ResponseEntity.ok(customerRepository.findAll(sort));
    }
    @GetMapping("/sorted-by-fields-and-direction") //sorted-by-fields-and-direction?lastName=ASC,firstName=DESC
    public ResponseEntity<List<Customer>> getAllCustomerSortedByFieldsAndDirections(@RequestParam Map<String, String> fieldDirections ) {
        Sort sort = Sort.by(fieldDirections.entrySet().stream()
                .map(entry -> new Sort.Order(Sort.Direction.fromString(entry.getValue()), entry.getKey()))
                .toArray(Sort.Order[]::new));

        return ResponseEntity.ok(customerRepository.findAll(sort));
    }

    @GetMapping("/pagination/{pageNumber}/{pageSize}")
    public ResponseEntity<Page<Customer>> getAllCustomerWithPagination(@PathVariable int pageNumber,
                                                                       @PathVariable int pageSize) {
        //return ResponseEntity.ok(customerService.findAllWithPagination(pageNumber,pageSize));
        Pageable pageable= PageRequest.of(pageNumber,pageSize);
        return ResponseEntity.ok(customerRepository.findAll(pageable));
    }

    @GetMapping("/sorted-by-field-and-pagination") ///sort?fieldName=lastName
    public ResponseEntity<Page<Customer>> getAllCustomerSortedByFieldAndPagination(@RequestParam int pageNumber,
                                                                                   @RequestParam int pageSize,
                                                                                   @RequestParam String fieldName ) {

        Sort sort = Sort.by(Sort.Direction.DESC,fieldName);
        Pageable pageable=PageRequest.of(pageNumber,pageSize,sort);
        return ResponseEntity.ok(customerRepository.findAll(pageable));
    }
    @GetMapping("/sorted-by-fields-and-pagination") ///sorted-by-fields?fieldNames=lastName,firstName
    public ResponseEntity<Page<Customer>> getAllCustomerSortedByFieldsAndPagination(@RequestParam int pageNumber,
                                                                                    @RequestParam int pageSize,
                                                                                    @RequestParam List<String> fieldNames ) {
        Sort sort = Sort.by(fieldNames.toArray(new String[0]));
        Pageable pageable=PageRequest.of(pageNumber,pageSize,sort);
        return ResponseEntity.ok(customerRepository.findAll(pageable));
    }


    @GetMapping("/sorted-by-fields-and-direction-and-pagination/{pageNumber}/{pageSize}") //sorted-by-fields-and-direction?lastName=ASC,firstName=DESC
    public ResponseEntity<Page<Customer>> getAllCustomerSortedByFieldsAndDirectionsAndPagination(@RequestParam Map<String, String> fieldDirections,
                                                                                                 @PathVariable(name = "pageNumber") int pageNumber,
                                                                                                 @PathVariable(name = "pageSize") int pageSize
    ) {
        Sort sort = Sort.by(fieldDirections.entrySet().stream()
                .map(entry -> new Sort.Order(Sort.Direction.fromString(entry.getValue()), entry.getKey()))
                .toArray(Sort.Order[]::new));

        Pageable pageable=PageRequest.of(pageNumber,pageSize,sort);
        return ResponseEntity.ok(customerRepository.findAll(pageable));
    }

    @GetMapping("/find-by-lastname/{lastName}")
    public ResponseEntity<List<Customer>> getCustomerByLastName(@PathVariable(name = "lastName")  String lastName,
                                                                @RequestParam int pageNumber,
                                                                @RequestParam int pageSize,
                                                                @RequestParam String fieldName) {
        Sort sort = Sort.by(fieldName);
        Pageable pageable=PageRequest.of(pageNumber,pageSize,sort);
        return ResponseEntity.ok(customerRepository.findByLastName(lastName,pageable));
    }

    @GetMapping("/find-by-lastname-query/{lastName}")
    public ResponseEntity<List<Customer>> getCustomerByLastNameQuery(@PathVariable(name = "lastName")  String lastName,
                                                                     @RequestParam int pageNumber,
                                                                     @RequestParam int pageSize,
                                                                     @RequestParam String fieldName) {
        Sort sort = Sort.by(fieldName);
        Pageable pageable=PageRequest.of(pageNumber,pageSize,sort);
        return ResponseEntity.ok(customerRepository.getCustomerByLastNameQueryPagination(lastName,pageable));
    }

}
