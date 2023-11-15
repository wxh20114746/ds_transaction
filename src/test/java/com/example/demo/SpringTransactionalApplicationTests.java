package com.example.demo;

import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringTransactionalApplicationTests {

    @Resource
    private UserService userService;
    @Test
    void contextLoads() {
        userService.Add();
    }

}
