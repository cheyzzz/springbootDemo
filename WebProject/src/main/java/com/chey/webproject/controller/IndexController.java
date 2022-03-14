package com.chey.webproject.controller;

import com.chey.webproject.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author chey
 * @Date 2022-02-22 16:47
 * @Describe  页面跳转
 */

@Controller
public class IndexController {

    //进入登录页
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "loginPage";//返回视图页面给模板引擎解析  thymeleaf自动找到templates文件夹下的login.html
    }

    //表单提交 登录后进入索引页主页
    @PostMapping(value = {"/index"})
    public String main(User user, HttpSession session,Model model) {
        //判断提交的表单信息是否正确  传递session用以拦截器使用
        if(!StringUtils.isEmpty(user.getUsername())&&StringUtils.hasLength(user.getPassword())){
            session.setAttribute("loginuser",user);//传session给索引页用以拦截过滤
            return "redirect:/index";//重定向 redirect用get   解决表单post刷新导致重复提交
        }else{
            model.addAttribute("msg","user error");
            return "loginPage";//返回登录页
        }

    }

    //解决刷新为表单重复提交问题  用get解决表单post刷新导致重复提交
    @GetMapping(value = {"/index"})
    public String mainPage(HttpSession session,Model model){
        //自制拦截器 用传进来的session判断  用model提示
//        if(null != session.getAttribute("loginuser")){
//            return "indexPage";
//        }else{
//            model.addAttribute("msg","no login");
//            return "loginPage";
//        }
        return "indexPage";
    }

}
