package com.chey.demo.config;

import com.chey.demo.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author chey
 * @Date 2021-11-26 16:32
 * @Describe
 */

@Configuration
public class MyConfig {
    @Bean
    public HelloService helloService(){
        System.out.println("bean class");
        return new HelloService();
    }
}
