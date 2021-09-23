package com.akhilesh.restcontroller;

import com.akhilesh.entity.Customer;
import com.akhilesh.errorhandling.CustomerException;
import com.akhilesh.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/customer/all")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }


    /*
    https://stackoverflow.com/questions/30511911/getting-not-supported-media-type-error
     */
    @PostMapping("/customer")
    public Customer addCustomer(@RequestBody Customer customer){

        //In DAO we have used save or update method so 0 acts as null and hence a new customer will be added
        customer.setId(0);
        customerService.saveCustomer(customer);
        return customer;
    }
}
