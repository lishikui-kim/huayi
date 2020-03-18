package com.example.mimile.controllers;

import com.example.mimile.dao.DBConnecter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private DBConnecter dbConnecter;

    @GetMapping("/hello")
    public String hello1() {
        return dbConnecter.configure();
    }

}
