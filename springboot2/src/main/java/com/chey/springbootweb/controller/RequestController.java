package com.chey.springbootweb.controller;

import com.chey.springbootweb.pojo.Person;
import javafx.scene.shape.Path;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author chey
 * @Date 2021-12-23 17:08
 * @Describe rest风格   返回字符串为字符串
 */
@RestController
public class RequestController {

    //四种请求方法  当为DELETE请求/user时
    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String delUser(){
        return "DELETE";
    }
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String putUser(){
        return "PUT";
    }
    
//    @RequestMapping(value = "/user",method = RequestMethod.POST)
//    public String postUser(){
//        return "POST";
//    }
//    @RequestMapping(value = "/user",method = RequestMethod.GET)
//    public String getUser(){
//        return "GET";
//    }


    //传参  浏览器输入参数为实参  方法的形参为获得的参数
    @RequestMapping("/age/{age}/name/{name}")
    public Map<String,Object> restRequest(@PathVariable("age") Integer age//路径变量 从输入的请求参数中获得
                                          ,@PathVariable("name") String name//路径变量 从输入的请求参数中获得
                                          ,@PathVariable Map<String,String> pv
                                          ,@RequestHeader("User-Agent") String userAgent//获取请求头 从浏览器请求头参数中获得
                                          ,@RequestHeader Map<String,String> header//获取请求头 从浏览器请求头参数中获得
                                          //,@RequestParam("id") Integer id//获取请求参数 从输入的请求参数中获得
                                          //,@RequestParam("like") List<String> like//获取请求参数 从输入的请求参数中获得
                                          ,@RequestParam Map<String,String> params//获取请求参数 从输入的请求参数中获得
//                                         ,@CookieValue("_ga") String _ga
//                                         ,@CookieValue("_ga") Cookie cookie_ga
                                          ){
        Map<String,Object> map = new HashMap<>();//返回的map
//        map.put("age",age);//设置map的key为字符串常量age value为参数age
//        map.put("name",name);
        map.put("pv",pv);
//        map.put("User-Agent",userAgent);
//        map.put("header",header);
//        map.put("id",id);
//        map.put("like",like);
        map.put("params",params);
//        map.put("_ga",_ga);
//        map.put("cookie_ga",cookie_ga);
//        map.put("cookie_ga_name",cookie_ga.getName());
//        map.put("cookie_ga_value",cookie_ga.getValue());
        return map;
    }

    @RequestMapping("/input")
    public Map<String,Object> bodyRequest(@RequestBody String requestBody){
        Map<String,Object> map = new HashMap<>();
        map.put("requestBody",requestBody);
        return map;
    }

    //请求格式是/matrix;num=1;list=aa,vv  matrix为路径变量 即path num和list为矩阵变量
    //请求格式是/matrix;num=1/matt;list=aa,vv  matrix matt为路径变量 即path num和list为矩阵变量
//    @RequestMapping("/{path}")
    //请求格式是/matrix;num=1/matrix2;num=2  若存在同名矩阵变量 则可以加个路径变量matrix2
    @RequestMapping("/{path1}/{path2}")  //两个路径变量
    public Map  matrixRequest(//@MatrixVariable("num") Integer num,
//                                @MatrixVariable("list") List list,
                              @MatrixVariable(value = "num",pathVar = "path1") Integer num1,//两个同名变量 用pathVar路径变量区分
                              @MatrixVariable(value = "num",pathVar = "path2") Integer num2,
                                @PathVariable("path1") String Path1,
                              @PathVariable("path2") String Path2){
        Map<String,Object> map = new HashMap<>();

        map.put("num1",num1);
        map.put("num2",num2);
//        map.put("list",list);
        map.put("path1",Path1);//path为分号前的字符串
        map.put("path2",Path2);//path为分号前的字符串
        return map;
    }


    //请求参数为javabean的属性值
    @PostMapping("/person")
    public Person Parm(Person person){

        return person;

    }


}
