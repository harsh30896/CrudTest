package com.crudTest.crudExample.controller;

import com.crudTest.crudExample.exception.ResourceNotFoundException;
import com.crudTest.crudExample.model.Employee;
import com.crudTest.crudExample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/api/v1/getAllEmp")
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    @PostMapping("/api/v1/addEmployee")
    public Employee createEmployee(@RequestBody Employee employee)
    {
        return employeeRepository.save(employee);
    }

    @GetMapping("/api/v1/getEmployeeById/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id)
    {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource NOt found with id "+id));
        return ResponseEntity.ok(employee);

    }

    @PutMapping("/api/v1/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails)
    {
     Employee updateEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource NOt found with id "+id));
    updateEmployee.setLastName(employeeDetails.getLastName());
    updateEmployee.setEmail(employeeDetails.getEmail());
    updateEmployee.setId(employeeDetails.getId());
    employeeRepository.save(updateEmployee);
    return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("/api/v1/deleteEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id)
    {
        Employee deleteEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource NOt found with id "+id));
        employeeRepository.delete(deleteEmployee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
