package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public int giveMeANumber(int max) {
        return jdbcTemplate.queryForObject("SELECT FLOOR(RANDOM() * ?)", Integer.class, max);
    }

    public int giveMeANumber() {
        return this.giveMeANumber(100);
    }
}
