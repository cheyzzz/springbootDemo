package com.chey.springbootweb.pojo;

import lombok.Data;

/**
 * @Author chey
 * @Date 2022-01-18 16:25
 * @Describe
 */
@Data
public class Person {
    String name;
    Integer age;
    Pet pet;
}
