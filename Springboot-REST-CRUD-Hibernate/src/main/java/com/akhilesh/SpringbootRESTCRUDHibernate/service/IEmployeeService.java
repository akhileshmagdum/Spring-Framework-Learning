package com.akhilesh.SpringbootRESTCRUDHibernate.service;

import com.akhilesh.SpringbootRESTCRUDHibernate.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> getAllEmployee();

    public Employee getSingleEmployee(int id);

    public Employee saveEmployee(Employee employee);

    public void deleteEmployee(int id);
}
