package com.akhilesh.SpringbootRESTCRUDHibernate.restcontroller;


import com.akhilesh.SpringbootRESTCRUDHibernate.entity.Employee;
import com.akhilesh.SpringbootRESTCRUDHibernate.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
