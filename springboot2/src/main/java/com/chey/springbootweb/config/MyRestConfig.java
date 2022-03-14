package com.chey.springbootweb.config;

import com.chey.springbootweb.converter.MyMessageConverter;
import com.chey.springbootweb.pojo.Person;
import com.chey.springbootweb.pojo.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;
import org.thymeleaf.util.StringUtils;

import java.util.*;

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


    /*
     *@Description springMVC功能自定义定制  返回WebMvcConfigurer接口类型的匿名对象
     *@Date 2022/2/14 11:06
     *@Params 
     *@Return null
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        //返回匿名对象  重写功能
        return new WebMvcConfigurer() {


            //开启矩阵值 法二 返回WebMvcConfigurer对象中重写configurePathMatch
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
//                WebMvcConfigurer.super.configurePathMatch(configurer);
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }

            //自定义请求参数形式的转换器
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

            //拓展消息转换器
            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new MyMessageConverter());//将自定义转换器添加
            }

            //修改消息转换器
//            @Override
//            public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//                WebMvcConfigurer.super.configureMessageConverters(converters);
//            }

            //自定义内容协商策略器  取代默认
//            @Override
//            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//                //自定义请求参数形式的数据类型
//                Map<String, MediaType> mediaTypes = new HashMap<>();
//                mediaTypes.put("json",MediaType.APPLICATION_JSON);
//                mediaTypes.put("xml",MediaType.APPLICATION_XML);
//                mediaTypes.put("person",MediaType.parseMediaType("application/type_person"));
//                ParameterContentNegotiationStrategy parameterContentNegotiationStrategy = new ParameterContentNegotiationStrategy(mediaTypes);
//                //parameterContentNegotiationStrategy.setParameterName("type_person");//可更改自定义数据类型的名字
//
//                HeaderContentNegotiationStrategy headerContentNegotiationStrategy = new HeaderContentNegotiationStrategy();
//
//                configurer.strategies(Arrays.asList(parameterContentNegotiationStrategy,headerContentNegotiationStrategy));
//
//            }


        };

    }
}
