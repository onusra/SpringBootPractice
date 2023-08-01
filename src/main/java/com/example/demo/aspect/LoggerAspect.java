package com.example.demo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    @Before("execution(* com.example.demo.employeController.EmployeeControl.create(..))")
    public void log(){
        System.out.println("Logging in controller");
    }
}
