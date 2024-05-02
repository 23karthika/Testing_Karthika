package com.example.day11_2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day11_2.model.Person;
import com.example.day11_2.service.PersonService;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;
    @PostMapping("/api/person")
    public Person postPerson(@RequestBody Person p)
    {
        return personService.postPerson(p);
    }
    @GetMapping("/api/person")
    public List<Person> getPersons()
    {
        return personService.getPerson();
    }
}
