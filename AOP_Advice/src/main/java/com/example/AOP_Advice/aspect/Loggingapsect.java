package com.example.AOP_Advice.aspect;

import com.example.AOP_Advice.dto.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Loggingapsect {

//    @Before("execution(String com.example.AOP_Advice.service.StudentService.savedStudent())")
//    public void logbeforerequest(JoinPoint joinPoint){
//
//        Object arr[]=joinPoint.getArgs();
//        System.out.println("student is going to be saved");
//    }


//    @AfterReturning(
//            pointcut = "execution(* com.example.AOP_Advice.service.StudentService.savedStudent(..))",
//            returning = "result"
//    )
//    public void afterReturning(Student result) {
//        System.out.println("before : " + result);
//        result.setName("khan");
//        result.setRollNo(123456);
//        System.out.println("after : " +result);
//    }


//    @AfterThrowing(
//            pointcut = "execution(* com.example.AOP_Advice.service.StudentService.savedStudent(..))",
//            throwing = "exception"
//    )
//    public void afterReturning(Throwable exception) {
//        System.out.println("exception type : " +exception.getClass().getName()) ;
//        System.out.println("exception msg : "  +exception.getLocalizedMessage());
//    }

//    @After(
//            value = "execution(* com.example.AOP_Advice.service.StudentService.savedStudent(..))"
//    )
//    public void aftermethod() {
//        System.out.println("after emthod executed");
//    }


//    @Around(
//            value = "execution(* com.example.AOP_Advice.service.StudentService.savedStudent(..))"
//    )
//    public Object  aroundmethod(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        System.out.println("Starting : " + joinPoint.getSignature().getName());
//        try{
//            Object result = joinPoint.proceed();
//            System.out.println("execution successful ");
//            return result;
//        } catch (Exception e) {
//            System.out.println("Exception message : " + e.getMessage());
//            throw e;
//        } finally {
//            System.out.println("execution completed");
//        }
//    }

    @Around(
            value = "execution(* com.example.AOP_Advice.service.StudentService.dummy_method(..))")
    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//
//       Object[] arr =  joinPoint.getArgs();
//
//       String originalString = (String) arr[0];
//
//       String modifiedString = originalString.toUpperCase();
//
//       Object[] modifiedArr = {
//               modifiedString
//       };
//
//       String returnType = (String) joinPoint.proceed(modifiedArr);
//
//       returnType = returnType + " : String Intercepted";
//
//       return returnType;

        Object return1 = joinPoint.proceed();

        System.out.println("Intercepted request calling again");

        Object return2 = joinPoint.proceed();
        return return2;

    }
}

