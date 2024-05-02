package com.example.day12_1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day12_1.model.Author;
import com.example.day12_1.repository.AuthorRepo;

@Service
public class AuthorService {
    @Autowired
    AuthorRepo authorRepo;
    public Author postAuthor(Author a)
    {
        return authorRepo.save(a);
    }
    public List<Author> getAuthor()
    {
        return authorRepo.findAll();
    }
}
