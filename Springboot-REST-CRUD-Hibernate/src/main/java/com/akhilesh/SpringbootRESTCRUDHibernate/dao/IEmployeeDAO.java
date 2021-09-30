package com.akhilesh.SpringbootRESTCRUDHibernate.dao;

import com.akhilesh.SpringbootRESTCRUDHibernate.entity.Employee;

import java.util.List;

public interface IEmployeeDAO {

    public List<Employee> getAllEmployee();

    public Employee getSingleEmployee(int id);

    public Employee saveEmployee(Employee employee);

    public void deleteEmployee(int id);

}
