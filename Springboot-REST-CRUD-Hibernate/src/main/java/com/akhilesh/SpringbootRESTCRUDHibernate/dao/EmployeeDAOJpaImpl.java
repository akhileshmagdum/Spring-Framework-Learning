package com.akhilesh.SpringbootRESTCRUDHibernate.dao;

import com.akhilesh.SpringbootRESTCRUDHibernate.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements IEmployeeDAO{

    private EntityManager manager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Employee> getAllEmployee() {

        Query query = manager.createQuery("from Employee");
        List<Employee> employeeList = query.getResultList();

        return employeeList;
    }

    @Override
    public Employee getSingleEmployee(int id) {
        Employee employee = manager.find(Employee.class,id);
        return employee;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        Employee dbEmployee = manager.merge(employee);
        return dbEmployee;
    }

    @Override
    public void deleteEmployee(int id) {
       Query query = manager.createQuery("delete from Employee where id=:employeeId");
       query.setParameter("employeeId",id);
       query.executeUpdate();
    }
}
