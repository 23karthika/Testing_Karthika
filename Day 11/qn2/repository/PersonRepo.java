package com.example.day11_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day11_2.model.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person,Long>{
    
}
