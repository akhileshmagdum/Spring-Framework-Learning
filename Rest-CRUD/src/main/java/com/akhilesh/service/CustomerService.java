package com.akhilesh.service;

import com.akhilesh.entity.Customer;
import java.util.List;

public interface CustomerService {
    public List<Customer> getAllCustomers();

    public void saveCustomer(Customer customer);//Will also update customer

    public Customer getSingleCustomer(int id);

    public void deleteCustomer(int id);

}
