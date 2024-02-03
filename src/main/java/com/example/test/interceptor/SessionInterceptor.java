package com.example.test.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class SessionInterceptor implements HandlerInterceptor {

    //调用目标方法之前执行的方法
    //如果返回ture表示拦截器验证成功，执行目标方法
    //如果返回false表示拦截器验证失败，不再继续执行后续业务
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //用户登录判断业务
        HttpSession session = request.getSession(true);
        if (session != null && session.getAttribute("session_userinfo") != null) {
            //用户已登录
            return true;
        }
        response.setStatus(405);
        return false;
    }
}