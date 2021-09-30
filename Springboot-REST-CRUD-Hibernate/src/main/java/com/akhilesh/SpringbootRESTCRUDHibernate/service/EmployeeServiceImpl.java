package com.akhilesh.SpringbootRESTCRUDHibernate.service;

import com.akhilesh.SpringbootRESTCRUDHibernate.dao.EmployeeRepository;
import com.akhilesh.SpringbootRESTCRUDHibernate.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    private EmployeeRepository dao;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository dao) {
        this.dao = dao;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return dao.findAll();
    }

    @Override
    public Employee getSingleEmployee(int id) {

        /*
        Optional is a container object used to contain not-null objects.
        Optional object is used to represent null with absent value.
        This class has various utility methods to facilitate code to handle values as ‘available’ or ‘not available’
        instead of checking null values.
         */

        Optional<Employee> result = dao.findById(id);
        Employee employee = null;

        if(result.isPresent()){
            employee = result.get();
        }

        return employee;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return dao.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        dao.deleteById(id);
    }
}
