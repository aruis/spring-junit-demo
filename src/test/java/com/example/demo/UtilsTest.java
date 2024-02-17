package com.example.demo;

import com.example.demo.utils.NumberTool;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilsTest {

    @Test
    void simple() {
        assertEquals(2, NumberTool.plus(1, 1));
    }

    @Test
    void simple2() {
        assertThat(NumberTool.plus(1, 1)).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "2,3,5"
    })
    void testPlus(int a, int b, double result) {
        assertEquals(result, NumberTool.plus(a, b));
    }
}
