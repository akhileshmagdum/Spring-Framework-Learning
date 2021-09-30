package com.akhilesh.SpringbootRESTCRUDHibernate.dao;

import com.akhilesh.SpringbootRESTCRUDHibernate.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
