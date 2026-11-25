package com.example.Types_of_proxies.aspectjs;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class loggingaspect {

    @Before("@within(org.springframework.stereotype.Service)")
    public void logbeforemethod() {
        System.out.println("method intercepted");
    }

//    @Before("execution(com.example.Types_of_proxies.DTO.Student"+"com.example.Types_of_proxies.service.StudentService.savedStudent("+"com.example.Types_of_proxies.DTO.Student))")
//    public void logbeforemethod2() {
//        System.out.println("method intercepted");
//    }

    public void logformet

}