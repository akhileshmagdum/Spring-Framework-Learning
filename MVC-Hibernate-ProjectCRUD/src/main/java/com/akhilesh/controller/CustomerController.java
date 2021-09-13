package com.akhilesh.controller;

import com.akhilesh.dao.CustomerDAO;
import com.akhilesh.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //Injecting customerDAO
    @Autowired
    private CustomerDAO customerDAO;

    @GetMapping("/list")
    public String listCustomers(Model model){

        List<Customer> customerList = customerDAO.getCustomers();

        model.addAttribute("customers",customerList);

        return "list-customers";
    }
}