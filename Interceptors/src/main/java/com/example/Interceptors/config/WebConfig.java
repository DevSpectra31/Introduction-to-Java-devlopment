package com.example.Interceptors.config;

import com.example.Interceptors.interceptors.AuthInterceptor;
import com.example.Interceptors.interceptors.AuthorizationInterceptor;
import com.example.Interceptors.interceptors.LoginInterceptors;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public LoginInterceptors loginInterceptors;
    public AuthInterceptor authInterceptor;
    public AuthorizationInterceptor authorizationInterceptor;
    public WebConfig(LoginInterceptors loginInterceptors,AuthInterceptor authInterceptor,AuthorizationInterceptor authorizationInterceptor){
        this.loginInterceptors=loginInterceptors;
        this.authInterceptor=authInterceptor;
        this.authorizationInterceptor = authorizationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry){
        System.out.println("webconfig is working");
        interceptorRegistry.addInterceptor(authInterceptor)
                .addPathPatterns("/api/*")
                .excludePathPatterns("/api/login")
                        .order(1);
        interceptorRegistry.addInterceptor(authorizationInterceptor)
                .order(2);
        interceptorRegistry.addInterceptor(authorizationInterceptor)
                .order(3);
    }
}
