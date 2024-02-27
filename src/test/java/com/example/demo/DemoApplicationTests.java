package com.example.demo;

import com.example.demo.service.DatabaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;

//@SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

    @Autowired
    private JdbcTemplate db;

    @Autowired
    private DatabaseService service;

    @Test
    void testDB() {
        int res = db.queryForObject("select 1", Integer.class);
        assertThat(res).isEqualTo(1);
    }

}
