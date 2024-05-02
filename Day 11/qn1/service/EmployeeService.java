package com.example.day11_1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day11_1.model.Employee;
import com.example.day11_1.repository.EmployeeRepo;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;
    public Employee postEmployee(Employee e)
    {
        return employeeRepo.save(e);
    }
    public List<Employee> getEmployees()
    {
        return employeeRepo.findAll();
    }
}
