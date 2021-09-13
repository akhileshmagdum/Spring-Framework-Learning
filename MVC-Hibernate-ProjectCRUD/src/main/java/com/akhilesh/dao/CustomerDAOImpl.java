package com.akhilesh.dao;

import com.akhilesh.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    //Injecting dependency from the servlet.xml file
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        Session session = sessionFactory.getCurrentSession();

        //Sorting my first name
        Query<Customer> customerQuery = session.createQuery("from Customer order by firstName",Customer.class);
        List<Customer> customers = customerQuery.getResultList();

        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.save(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class,id);
        return customer;
    }
}
