package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DemoApplicationTests2 {

    private JdbcTemplate db = mock(JdbcTemplate.class);

//    @Test
    void testDB() {
        when(db.queryForObject("select 1", Integer.class)).thenReturn(1);


        int res = db.queryForObject("select 1", Integer.class);
        assertThat(res).isEqualTo(1);
    }

}
