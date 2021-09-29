package com.akhilesh.SpringbootRESTCRUDHibernate.dao;

import com.akhilesh.SpringbootRESTCRUDHibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements IEmployeeDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployee() {

        Session session = entityManager.unwrap(Session.class);
        Query<Employee> query = session.createQuery("from Employee",Employee.class);
        List<Employee> employeeList = query.getResultList();

        return employeeList;
    }
}
