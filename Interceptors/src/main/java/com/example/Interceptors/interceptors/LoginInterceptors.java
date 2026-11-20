package com.example.Interceptors.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginInterceptors implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("incoming request : ");
        System.out.println("method name : " + request.getMethod());
        System.out.println("request uri : " + request.getRequestURI());
        System.out.println("request parameters : " +request.getQueryString());
        System.out.println("client ip : " +request.getRemoteAddr());
        System.out.println("request header : " + request.getHeader("token"));
        if(handler instanceof HandlerMethod method){
            System.out.println("controller name :  " + method.getBeanType().getName());
            System.out.println("controller method : " + method.getMethod().getName());
        }
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                  Exception ex) throws Exception {
        System.out.println("Response status : "+ response.getStatus());
    }
}
