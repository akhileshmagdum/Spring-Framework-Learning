package com.akhilesh.SpringbootRESTCRUDHibernate.service;

import com.akhilesh.SpringbootRESTCRUDHibernate.dao.IEmployeeDAO;
import com.akhilesh.SpringbootRESTCRUDHibernate.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    private IEmployeeDAO dao;

    @Autowired
    public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") IEmployeeDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployee() {
        return dao.getAllEmployee();
    }

    @Override
    @Transactional
    public Employee getSingleEmployee(int id) {
        return dao.getSingleEmployee(id);
    }

    @Override
    @Transactional
    public Employee saveEmployee(Employee employee) {
        return dao.saveEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        dao.deleteEmployee(id);
    }
}
