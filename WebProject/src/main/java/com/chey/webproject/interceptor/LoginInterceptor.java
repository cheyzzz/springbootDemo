package com.chey.webproject.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author chey
 * @Date 2022-03-02 9:37
 * @Describe
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("拦截了"+requestURI);

        HttpSession session = request.getSession();
        Object loginuser = session.getAttribute("loginuser");
        //获得的session来判断拦截
        if(loginuser != null){
            return true;
        }
        //登陆失败提示法一   使用session传递数据和重定向  配合th:text="${session.msg}"取得  如果是th:text="${msg}"则取得是request的msg 但是重定向request请求域已经改变
//        session.setAttribute("msg","please login");
//        response.sendRedirect("/");
        //登陆失败提示法二   使用request传递数据和转发
        request.setAttribute("msgg","please loginn");
        request.getRequestDispatcher("/").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
