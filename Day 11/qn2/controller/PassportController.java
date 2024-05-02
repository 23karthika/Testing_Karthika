package com.example.day11_2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day11_2.model.Passport;
import com.example.day11_2.service.PassportService;

@RestController
public class PassportController {
    @Autowired
    PassportService passportService;
    @PostMapping("/api/passport")
    public Passport postPassport(@RequestBody Passport p)
    {
        return passportService.postPassport(p);
    }
    @GetMapping("/api/passport")
    public List<Passport> getPassport()
    {
        return passportService.getPassport();
    }
}
