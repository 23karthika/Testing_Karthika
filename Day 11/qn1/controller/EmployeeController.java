package com.example.day11_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day11_1.model.Employee;
import com.example.day11_1.service.EmployeeService;

@RestController
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeService;
    @PostMapping("/api/employee")
    public Employee postEmployee(@RequestBody Employee e)
    {
        return employeeService.postEmployee(e);
    }
    @GetMapping("/api/employee")
    public List<Employee> getEmployees()
    {
        return employeeService.getEmployees();
    }
}
