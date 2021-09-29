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

    @Autowired
    private IEmployeeService service;

    @RequestMapping("/employee-all")
    public List<Employee> showAllEmployee(){
        return service.getAllEmployee();
    }
}
