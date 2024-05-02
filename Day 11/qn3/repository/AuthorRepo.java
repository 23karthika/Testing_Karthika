package com.example.day12_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day12_1.model.Author;

@Repository
public interface AuthorRepo extends JpaRepository<Author,Long>{
    
}
