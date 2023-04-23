package com.chey.springbootweb;

import com.chey.aop.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.*;

/*
 *@Description 测试类 用junit4
 *      ·注入的类不能是main里的
 *      ·引入两个注解
            @RunWith(SpringJUnit4ClassRunner.class) //或 (SpringRunner.class)
            @SpringBootTest //(classes = Springboot2Application.class)classes可省略
 *@Date 2023/4/23 22:35
 *@Params
 *@Return null
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot2ApplicationTests {

    @Autowired(required = false)
    private UserService userService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test(){
        System.out.println("test");
        userService.add();
    }



}
