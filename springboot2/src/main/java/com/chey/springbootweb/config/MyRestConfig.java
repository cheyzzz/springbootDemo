package com.chey.springbootweb.config;

import com.chey.springbootweb.pojo.Person;
import com.chey.springbootweb.pojo.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;
import org.thymeleaf.util.StringUtils;

import java.util.Locale;

/**
 * @Author chey
 * @Date 2021-12-24 11:02
 * @Describe 自定义配置类
 */
@Configuration
public class MyRestConfig {
    //post过滤器
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        hiddenHttpMethodFilter.setMethodParam("hidmethod");
        return hiddenHttpMethodFilter;
    }


//    //返回自定义视图解析器  添加到容器
//    @Bean
//    public ViewResolver myViewResolver(){
//        return new MyViewResolver();
//    }
//
//    //自定义内部类视图解析器  实现ViewResolver
//    private static class MyViewResolver implements ViewResolver{
//        @Override
//        public View resolveViewName(String viewName, Locale locale) throws Exception {
//            return null;
//        }
//    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            //开启矩阵值 法二 返回WebMvcConfigurer对象中重写configurePathMatch
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
//                WebMvcConfigurer.super.configurePathMatch(configurer);
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }

            //自定义转换器
            @Override
            public void addFormatters(FormatterRegistry registry) {
//                WebMvcConfigurer.super.addFormatters(registry);
                registry.addConverter(new Converter<String, Pet>() {
                    @Override
                    public Pet convert(String source) {
                        //将传入参数的格式转为需要的格式
                        if(!StringUtils.isEmpty(source)){
                            Pet pet = new Pet();
                            String[] str = source.split(",");
                            pet.setName(str[0]);
                            pet.setAge(Integer.parseInt(str[1]));
                            return pet;
                        }
                        return null;
                    }
                });

            }
        };

    }
}
