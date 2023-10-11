package com.springboot.employeemanagementsystembackend.repository;

import com.springboot.employeemanagementsystembackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //JpaRepository exposes database core methods, like save(), findById(long id) etc, so we don't need to write any code
}
