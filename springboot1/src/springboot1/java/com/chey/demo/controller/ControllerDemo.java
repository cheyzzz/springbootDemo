package com.chey.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author chey
 * @Date 2021-10-20 16:12
 * @Describe controller层
 */
//@RestController
//public class ControllerDemo {
//    @RequestMapping("/hello")//接收前端接口参数 即访问localhost:8080/hello
//    public String print(){
//        //调用业务
//        return "hello controller";
//    }
//}

//@Controller
//@RequestMapping("/hello")
//public class ControllerDemo {
//    @GetMapping("/hello")
//    @ResponseBody
//    public String print(){
//        return "hello controller";
//    }
//}

@Controller
public class ControllerDemo {

//    @Value("${person.lastName}")
    private String lastName;

    @RequestMapping("/hello")
    @ResponseBody
    public String print(){

        return "hello controller"+lastName;
    }
}
