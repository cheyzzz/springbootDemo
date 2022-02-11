package com.chey.springbootweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

/**
 * @Author chey
 * @Date 2021-12-22 10:16
 * @Describe 实现WebMvcConfigurer    自定义配置类
 */
//@EnableWebMvc//接管springmvc
@Configuration//配置类
public class MyMvcConfig implements WebMvcConfigurer {//实现WebMvcConfigurer 实现springmvc配置

    //扩展springmvc  无逻辑直接跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        WebMvcConfigurer.super.addViewControllers(registry);
        registry.addViewController("/mypage").setViewName("hellooPage");
    }

    //开启矩阵值 法一  实现WebMvcConfigurer 重写configurePathMatch
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
//        WebMvcConfigurer.super.configurePathMatch(configurer);
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);

    }

}
