package com.chey.demo;

import com.chey.demo.bean.Cat;
import com.chey.demo.bean.Person;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

//@ImportResource(locations = {"classpath:beans.xml"})
@SpringBootTest
class DemoApplicationTests {

    //日志记录器
    Logger logger = LoggerFactory.getLogger(getClass());
    //绑定bean
    @Autowired
    Person person;
    @Autowired
    Cat cat;
    @Autowired
    ApplicationContext ioc;

    @Test
    void contextLoads() {
//        System.out.println(person);
        //级别  由低到高
//        logger.trace("trace");
//        logger.debug("debug");
//        logger.info("info");
//        logger.warn("warn");
//        logger.error("error");
        System.out.println(cat.age);
        cat.handle();
    }


    @Test
    void isExit(){
        System.out.println(ioc.containsBean("helloService"));
    }
}
