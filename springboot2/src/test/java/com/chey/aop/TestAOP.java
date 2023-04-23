package com.chey.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author chey
 * @Date 2023-04-23 20:54
 * @Describe
 */
@Aspect
@Component
public class TestAOP {

    @Pointcut("@annotation(com.chey.aop.annotation.MyAOP)")
//    @Pointcut("execution(* com.chey.*.*.*.*(..))")
    public void pointCut() {
        System.out.println("pointcut");
    }
    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("before");
        // 逻辑代码
    }
    @Around(value = "pointCut()")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("around before");
        try {
            Object obj = proceedingJoinPoint.proceed();
            System.out.println("around after");
            return obj;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
