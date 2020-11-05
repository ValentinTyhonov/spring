package com.example.spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging
{
    @Pointcut("execution(public * *..model.*.*(..))")
    public void selectAllMethodsAvaliable()
    {

    }

    @Before("selectAllMethodsAvaliable()")
    public void beforeAdvice()
    {
        System.out.println("Now we are going to initiate developer's profile.");
    }

    @After("selectAllMethodsAvaliable()")
    public void afterAdvice()
    {
        System.out.println("Developer's profile has been initiated.");
    }

    @AfterReturning(pointcut = "selectAllMethodsAvaliable()", returning = "someValue")
    public void afterReturningAdvice(Object someValue)
    {
        System.out.println("Value: " + someValue.toString());
    }

    @AfterThrowing(pointcut = "selectAllMethodsAvaliable()", throwing = "e")
    public void inCaseOfExceptionThrowAdvice(ClassCastException e)
    {
        System.out.println("We have an exception here: " + e.getMessage());
    }
}
