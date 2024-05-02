package com.example.day12_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day12_1.model.Author;
import com.example.day12_1.service.AuthorService;

@RestController
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @PostMapping("/api/author")
    public Author postAuthor(@RequestBody Author a)
    {
        return authorService.postAuthor(a);
    }
    @GetMapping("/api/author")
    public List<Author> geAuthors()
    {
        return authorService.getAuthor();
    }
}
