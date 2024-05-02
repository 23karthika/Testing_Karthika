package com.example.day12_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day12_1.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book,Long>{
    
}
