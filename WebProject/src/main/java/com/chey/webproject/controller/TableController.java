package com.chey.webproject.controller;

import com.chey.webproject.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @Author chey
 * @Date 2022-02-23 11:09
 * @Describe
 */
@Controller
public class TableController {
    @GetMapping("/basic_table")
    public String basic_table(){

        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){
        //遍历
        List<User> users = Arrays.asList(new User("aa", "11"),
                new User("bb", "11"),
                new User("cc", "11"));
        model.addAttribute("users",users);
        return "table/dynamic_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){

        return "table/editable_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){

        return "table/responsive_table";
    }
}
