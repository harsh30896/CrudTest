package com.crudTest.crudExample.repository;

import com.crudTest.crudExample.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;



public interface EmployeeRepository extends JpaRepository<Employee,Long>
{
    // all crud database methods

}
