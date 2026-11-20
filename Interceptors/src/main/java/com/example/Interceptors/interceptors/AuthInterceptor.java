package com.example.Interceptors.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String apikey = UUID.randomUUID().toString();
        apikey=request.getHeader("x-api-key");
        if(apikey == null || !apikey.equals("secret123")){
            return false;
        }
        return true;
    }

}
