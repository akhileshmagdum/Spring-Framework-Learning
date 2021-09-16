package com.akhilesh.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    //Setting up logger which is built-in java
    public Logger logger =Logger.getLogger(getClass().getName());

    //Pointcut on all the methods in controller class
    @Pointcut("execution(* com.akhilesh.controller.*.*(..))")
    private void forController(){ }

    @Pointcut("execution(* com.akhilesh.service.*.*(..))")
    private void forService(){ }

    @Pointcut("execution(* com.akhilesh.dao.*.*(..))")
    private void forDao(){ }

    @Pointcut("forController() || forDao() || forService()")
    public void forAll(){ }

    @Before("forAll()")
    public void before(JoinPoint point){
        String method = point.getSignature().toShortString();
        logger.info("Before "+method);
    }

    @AfterReturning(pointcut = "forAll()",returning = "obj")
    public void afterReturning(JoinPoint point,Object obj){
        String method = point.getSignature().toShortString();
        logger.info("AfterReturning "+method);

        logger.info(" "+obj); //Returns name of JSP pages
    }
}
