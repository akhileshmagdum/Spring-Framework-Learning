package com.akhilesh.SpringbootRESTCRUDHibernate.dao;

import com.akhilesh.SpringbootRESTCRUDHibernate.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
