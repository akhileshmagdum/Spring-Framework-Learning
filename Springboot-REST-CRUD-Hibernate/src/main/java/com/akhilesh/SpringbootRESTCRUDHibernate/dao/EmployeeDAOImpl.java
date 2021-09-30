package com.akhilesh.SpringbootRESTCRUDHibernate.dao;

import com.akhilesh.SpringbootRESTCRUDHibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements IEmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAllEmployee() {

        Session session = entityManager.unwrap(Session.class);
        Query<Employee> query = session.createQuery("from Employee",Employee.class);
        List<Employee> employeeList = query.getResultList();

        return employeeList;
    }

    @Override
    public Employee getSingleEmployee(int id) {

        Session session = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class,id);

        return employee;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {

        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId",id);
        query.executeUpdate();
    }
}
