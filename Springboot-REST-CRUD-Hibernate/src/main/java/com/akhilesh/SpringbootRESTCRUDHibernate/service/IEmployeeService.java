package com.akhilesh.SpringbootRESTCRUDHibernate.service;

import com.akhilesh.SpringbootRESTCRUDHibernate.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> getAllEmployee();
}
