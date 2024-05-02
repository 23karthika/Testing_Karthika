package com.example.day11_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day11_1.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long>{
    
}
