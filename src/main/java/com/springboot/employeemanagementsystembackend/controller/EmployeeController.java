package com.springboot.employeemanagementsystembackend.controller;

import com.springboot.employeemanagementsystembackend.model.Employee;
import com.springboot.employeemanagementsystembackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("http://localhost:4200")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    // Get all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Create employee
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) { //POST request contains a JSON request body so @RequestBody maps the JSON request body to the Employee object
        return employeeRepository.save(employee);
    }
}
