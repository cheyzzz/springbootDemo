package com.chey.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author chey
 * @Date 2023-04-23 22:44
 * @Describe 自定义注解，需要放在目标执行方法中调用的方法，直接放执行方法不生效
 */
@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAOP {
    String value() default "";

    String type() default "1";

}
