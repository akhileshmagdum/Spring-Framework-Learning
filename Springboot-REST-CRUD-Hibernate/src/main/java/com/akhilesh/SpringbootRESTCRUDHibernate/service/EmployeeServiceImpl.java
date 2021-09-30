package com.akhilesh.SpringbootRESTCRUDHibernate.service;

import com.akhilesh.SpringbootRESTCRUDHibernate.dao.IEmployeeDAO;
import com.akhilesh.SpringbootRESTCRUDHibernate.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    private IEmployeeDAO dao;

    @Autowired
    public EmployeeServiceImpl(IEmployeeDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployee() {
        return dao.getAllEmployee();
    }
}
