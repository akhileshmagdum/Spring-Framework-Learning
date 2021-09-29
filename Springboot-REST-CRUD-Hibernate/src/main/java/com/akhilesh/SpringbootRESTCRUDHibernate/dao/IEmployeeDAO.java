package com.akhilesh.SpringbootRESTCRUDHibernate.dao;

import com.akhilesh.SpringbootRESTCRUDHibernate.entity.Employee;

import java.util.List;

public interface IEmployeeDAO {

    public List<Employee> getAllEmployee();

}
