// CustomerRepository.java
package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CustomerRepository {
    private final Map<Long, Customer> customerData = new HashMap<>();
    private Long nextCustomerId = 1L;

    public Customer save(Customer customer) {
        customer.setId(nextCustomerId++);
        customerData.put(customer.getId(), customer);
        return customer;
    }

    public Customer findById(Long id) {
        return customerData.get(id);
    }

    public Map<Long, Customer> findAll() {
        return customerData;
    }
}
