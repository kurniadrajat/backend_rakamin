package com.example.demo.repository;
import com.example.demo.model.Customer;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class CustomerRepository {

    private final List<Customer> customers = new ArrayList<>();

    public Customer save (Customer customer) {
        customer.setId((long) (customers.size() + 1));
        customers.add(customer);
        return customer;
    }

    public Customer update (Customer customer) {
        customers.remove(customer.getId());
        customers.add(customer);
        return customer;
    }

    public List<Customer> findAll() {
        return customers;
    }

    public Optional<Customer> findById(Long id) {
        return customers.stream().filter(customer -> customer.getId().equals(id)).findFirst();

    }
}
