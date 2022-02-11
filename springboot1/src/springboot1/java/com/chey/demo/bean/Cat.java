package com.chey.demo.bean;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author chey
 * @Date 2021-12-23 10:43
 * @Describe bean  带lombok的注解data  代替getset tostring
 */
//@ToString//data已经包含 可不加
@Data//get set tostring
@AllArgsConstructor//全参构造器
@NoArgsConstructor//无参构造器
@EqualsAndHashCode//
@Slf4j//日志
@Component//设为springboot的组件
@ConfigurationProperties(prefix = "cat") //绑定对象名对应的配置文件
public class Cat {

    public int age;
    public String name;

    public void handle(){
        log.info("log");
    }
}
