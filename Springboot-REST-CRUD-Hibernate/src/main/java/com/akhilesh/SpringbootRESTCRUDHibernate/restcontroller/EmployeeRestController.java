package com.akhilesh.SpringbootRESTCRUDHibernate.restcontroller;


import com.akhilesh.SpringbootRESTCRUDHibernate.entity.Employee;
import com.akhilesh.SpringbootRESTCRUDHibernate.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    /*
    Why use constructor injection, when field and setter injection are present?
    https://dzone.com/articles/spring-di-patterns-the-good-the-bad-and-the-ugly
     */


    private IEmployeeService service;

    @Autowired
    public EmployeeRestController(IEmployeeService service) {
        this.service = service;
    }

    @RequestMapping("/employee-all")
    public List<Employee> showAllEmployee(){
        return service.getAllEmployee();
    }

    @RequestMapping("/employee/{id}")
    public Employee showSingleEmployee(@PathVariable int id){
        Employee employee = service.getSingleEmployee(id);
        if (employee==null){
            throw new RuntimeException("No employee found with "+id);
        }
        return employee;
    }

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        employee.setId(0);
        service.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable int id){
        service.deleteEmployee(id);
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee){
        service.saveEmployee(employee);
        return employee;
    }
}
