package com.akhilesh.SpringbootRESTCRUDHibernate.service;

import com.akhilesh.SpringbootRESTCRUDHibernate.dao.IEmployeeDAO;
import com.akhilesh.SpringbootRESTCRUDHibernate.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    private IEmployeeDAO dao;

    @Override
    @Autowired
    public List<Employee> getAllEmployee() {
        return dao.getAllEmployee();
    }
}
