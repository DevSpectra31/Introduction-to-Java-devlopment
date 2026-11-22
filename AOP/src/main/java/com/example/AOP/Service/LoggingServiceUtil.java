package com.example.AOP.Service;



public class LoggingServiceUtil {

    public static void logstartstart(String className, String methodName){

        System.out.println("executing ");
        System.out.println(className + " " + methodName);
    }

    public static  void logsends(String className,String methodName){
        System.out.println("executing");
        System.out.println(className + " " + methodName);
    }
}
