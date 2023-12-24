// CustomerService.java
package com.example.demo.service;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerService {
    private final Map<Long, Customer> customerData = new HashMap<>();
    private Long nextCustomerId = 1L;

    public CustomerService() {
        // Initialize customer data as before
        // ...
    }

    public Customer getCustomerBalance(Long customerId) {
        if (customerData.containsKey(customerId)) {
            return customerData.get(customerId);
        } else {
            throw new RuntimeException("Customer not found with ID: " + customerId);
        }
    }

    public void saveCustomer(Customer customer) {
        customer.setId(nextCustomerId++);
        customerData.put(customer.getId(), customer);
    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customerData.values());
    }

    public Customer updateCustomer(Long customerId, Customer updatedCustomer) {
        if (customerData.containsKey(customerId)) {
            updatedCustomer.setId(customerId);
            customerData.put(customerId, updatedCustomer);
            return updatedCustomer;
        } else {
            throw new RuntimeException("Customer not found with ID: " + customerId);
        }
    }

    public boolean deleteCustomer(Long customerId) {
        if (customerData.containsKey(customerId)) {
            customerData.remove(customerId);
        } else {
            throw new RuntimeException("Customer not found with ID: " + customerId);
        }
        return false;
    }
}
