package com.akhilesh.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(public void com.akhilesh.dao.AccountDAO.addAccount(com.akhilesh.pojo.Account))")
    public void beforeAddAccountAdvice(){
        System.out.println(">>>>>>>>>Aspect advice from "+getClass());
    }
}