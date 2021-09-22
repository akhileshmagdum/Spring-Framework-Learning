package com.akhilesh.restcontroller;

import com.akhilesh.entity.Customer;
import com.akhilesh.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customer/{customerId}")
    public Customer showSingleCustomer(@PathVariable int customerId){
        return customerService.getSingleCustomer(customerId);
    }
}
