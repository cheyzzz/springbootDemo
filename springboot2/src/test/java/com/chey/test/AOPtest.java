package com.chey.test;

import com.chey.aop.annotation.MyAOP;
import com.chey.aop.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author chey
 * @Date 2023-04-23 20:59
 * @Describe
 */
@SpringBootTest
public class AOPtest {

    @Autowired(required = false)
    private UserService userService;

    @Test
    @MyAOP(type = "1")
    void test(){
        System.out.println("test");
        userService.add();
    }

}
