package com.chey.aop.service.impl;

import com.chey.aop.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author chey
 * @Date 2023-04-23 20:52
 * @Describe
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
//    @MyAOP(type = "2")
    public void add() {
        System.out.println("add");
    }
}
