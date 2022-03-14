package com.chey.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author chey
 * @Date 2021-12-17 10:24
 * @Describe springmvc controller   返回字符串为视图页面
 */
@Controller
public class WebController {
    @ResponseBody//返回字符串
    @RequestMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @RequestMapping("/thymehelloo")
    public String sayHelloo(Map<String, Object> map) {
        map.put("key1", "你好");//使用${key1}获得key1的值
        map.put("key2", "<h1>你好</h1>");//使用utext转义
        map.put("users", Arrays.asList("张三", "李四", "王五", "赵六"));
        map.put("link", "www.zyjkoa.com");//
        return "thymePage";//返回视图给视图解析器  访问localhost:8080/helloo映射到templates/thymePage.html  由于前后缀都已自动配置好 可以找到
    }

    @RequestMapping("/thymehello1")
    public String sayHello1(Model model) {
        model.addAttribute("msg", "msgggg");//${msg}获得msg的值


        return "hello1";//返回视图给视图解析器  访问会报错因为hello1.html不在templates文件夹里
    }

    @RequestMapping("/servletgo")
    public String go(HttpServletRequest request) {//HttpServletRequest 获得request
        request.setAttribute("msg", "111");//请求设置属性值
        return "forward:/come";//转发到come的请求
    }


    @RequestMapping("/mapmodelgo")
    public String mapModelGo(Map<String, Object> map,
                             Model model,
                             HttpServletResponse response) {
        map.put("map", "mapppp");
        model.addAttribute("model", "modellll");

        Cookie cookie = new Cookie("cookie", "cookieeee");
        response.addCookie(cookie);
        return "forward:/come";
    }

    @ResponseBody
    @RequestMapping("/come")
    public Map come(//@RequestAttribute(value = "msg",required = false) String msg,
                    HttpServletRequest request//转发  请求是同一个
    ) {
        Map<String, Object> map = new HashMap<>();
        Object requestAttribute = request.getAttribute("msg");

        Object mapAttribute = request.getAttribute("map");
        Object modelAttribute = request.getAttribute("model");


        map.put("attribute", requestAttribute);
//        map.put("msg",msg);
        map.put("mapAttribute", mapAttribute);
        map.put("modelAttribute", modelAttribute);
        return map;
    }


}
