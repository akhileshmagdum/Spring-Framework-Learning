package com.akhilesh.restcontroller;

import com.akhilesh.entity.Customer;
import com.akhilesh.errorhandling.CustomerException;
import com.akhilesh.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer/{customerId}")
    public Customer showSingleCustomer(@PathVariable int customerId){
        Customer customer = customerService.getSingleCustomer(customerId);
        if(customer == null){
            throw new CustomerException("Customer not found");
        }
        return customer;
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
}
