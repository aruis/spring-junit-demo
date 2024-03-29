package com.example.demo.service;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DatabaseServiceTest {

    @Autowired
    private DatabaseService databaseService;

    @RepeatedTest(100)
    void giveMeANumber() {
        int number = databaseService.giveMeANumber();
        assertThat(number).isBetween(1, 100);
    }

    @Test
    void testGiveMeANumber() {
        int number = databaseService.giveMeANumber(10);
        assertThat(number).isBetween(1, 10);
    }
}
