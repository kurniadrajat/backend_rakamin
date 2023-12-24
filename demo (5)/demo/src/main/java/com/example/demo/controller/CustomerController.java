package com.example.demo.controller;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController (CustomerService customerService) {
        this.customerService = customerService;
    }

    
    @PostMapping("/create")
    public Customer createCustomer (@RequestBody Customer customer) {
        customerService.createCustomer(customer);

        return customer;
    }
    @GetMapping("/{id}/balance")
    public Customer getCustomerBalance (@PathVariable Long id) {

        Customer customer = customerService.getCustomerBalance(id);

        if (customer  == null) {

            return new Customer(id, "Customer Not Found", 0.0);
        }

        return customer;
    }
}
