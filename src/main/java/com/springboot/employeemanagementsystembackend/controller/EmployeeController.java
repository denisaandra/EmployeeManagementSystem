package com.springboot.employeemanagementsystembackend.controller;

import com.springboot.employeemanagementsystembackend.exception.ResourceNotFoundException;
import com.springboot.employeemanagementsystembackend.model.Employee;
import com.springboot.employeemanagementsystembackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @PostMapping("/employees") // We use @RequestBody because the request contains a JSON request body and we want to map it directly to the employee object.
    public Employee createEmployee(@RequestBody Employee employee) { //POST request contains a JSON request body so @RequestBody maps the JSON request body to the Employee object
        return employeeRepository.save(employee);
    }

    // Get Employee by id
    @GetMapping("/employees/{id}") // We want to store this path id value into the Java variable, so for that we are going to use @PathVariable annotation to map the url {id} into the variable
    public ResponseEntity<Employee>  getEmployeeById(@PathVariable Long id) {
        Employee employee= employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with this id: " + id));

        return ResponseEntity.ok(employee);
    }

    // Update Employee
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee existingEmployee = this.employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with this id: " + id));
        existingEmployee.setfirstName(employeeDetails.getfirstName());
        existingEmployee.setLastName(employeeDetails.getLastName());
        existingEmployee.setEmailId(employeeDetails.getEmailId());

        Employee updatedEmployee = this.employeeRepository.save(existingEmployee);

        return ResponseEntity.ok(updatedEmployee);
    }




}

