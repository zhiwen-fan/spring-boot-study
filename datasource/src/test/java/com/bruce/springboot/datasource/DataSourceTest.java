package com.bruce.springboot.datasource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Server.class)
public class DataSourceTest {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testTimeout() throws InterruptedException {
        System.out.println("############staart#############");
        Thread.sleep(5000);
        jdbcTemplate.execute("select sleep(1)");
    }
}
