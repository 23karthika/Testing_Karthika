package com.example.day11_2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day11_2.model.Passport;
import com.example.day11_2.repository.PassportRepo;

@Service
public class PassportService {
    @Autowired
    PassportRepo passportRepo;
    public Passport postPassport(Passport p)
    {
        return passportRepo.save(p);
    }
    public List<Passport> getPassport()
    {
        return passportRepo.findAll();
    }
    
}
