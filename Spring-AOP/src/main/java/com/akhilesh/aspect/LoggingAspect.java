package com.akhilesh.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(public void com.akhilesh.dao.AccountDAO.addAccount(com.akhilesh.pojo.Account))")
    public void pointcutDeclarations(){  }

    @Before("pointcutDeclarations()")
    public void beforeAddAccountAdvice(){
        System.out.println(">>>>>>>>>Aspect advice from "+getClass());
    }

    @Before("pointcutDeclarations()")
    public void beforeDemo(){
        System.out.println("<<<<<<<<Another aspect advice from "+getClass());
    }

    @Pointcut("execution(public * com.akhilesh.pojo.Account.get*())")
    public void pointcutGetter(){ }

    @Pointcut("execution(public * com.akhilesh.pojo.Account.set*(*))")
    public void pointcutSetter(){ }

    @Before("pointcutGetter() || pointcutSetter()")
    public void forEveryGetter(){
        System.out.println("THIS IS AOP");
    }
}