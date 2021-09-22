package com.akhilesh.service;

import com.akhilesh.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);

    public Customer getCustomer(int id);

    public void deleteCustomer(int id);

    List<Customer> searchCustomers(String searchName);
}