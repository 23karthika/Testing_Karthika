package com.example.day11_2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day11_2.model.Person;
import com.example.day11_2.repository.PersonRepo;

@Service
public class PersonService {
    @Autowired
    PersonRepo personRepo;
    public Person postPerson(Person p)
    {
        return personRepo.save(p);
    }
    public List<Person> getPerson()
    {
        return personRepo.findAll();
    }
}
