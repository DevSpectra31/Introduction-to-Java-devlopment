package com.example.Types_of_proxies.aspectjs;

import org.aspectj.lang.annotation.Pointcut;

public class ApplicationPointcut {

    @Pointcut("within(com.example.Types_of_proxies.controller..*)")
    public void controllerLayer() {
        // emoty body
    }

    @Pointcut("within(com.example.Types_of_proxies.controller..*)")
    public void serviceLayer() {
        // empty body
    }

    @Pointcut("execution(public * * (..))")
    public void publicMethod() {
        // empty body
    }

    @Pointcut("serviceLayer() && publicMethod()")
    public void publicServiceMethod() {
        // empty body
    }

    @Pointcut("execution(* *.get* (..))")
    public void getterMethod() {
        // empty body
    }
}
