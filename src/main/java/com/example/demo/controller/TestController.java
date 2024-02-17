package com.example.demo.controller;

import com.example.demo.service.DatabaseService;
import com.example.demo.utils.NumberTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class TestController {

    @Autowired
    DatabaseService databaseService;

    @GetMapping("/testDB")
    public int testDB() {

        int a = databaseService.giveMeANumber();
        int b = databaseService.giveMeANumber();

        return NumberTool.plus(a, b);
    }

}
