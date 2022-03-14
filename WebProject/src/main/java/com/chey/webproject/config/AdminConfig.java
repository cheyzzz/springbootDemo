package com.chey.webproject.config;

import com.chey.webproject.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author chey
 * @Date 2022-03-02 10:45
 * @Describe
 */
@Configuration
public class AdminConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")//拦截
                .excludePathPatterns("/","login","/css/**","/fonts/**","/images/**","/js/**","/error");//放行
    }
}
