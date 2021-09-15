package com.akhilesh.aspect;

import com.akhilesh.pojo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class LoggingAspect {

    @AfterReturning(pointcut = "execution(public * com.akhilesh.dao.AccountDAO.findAccounts(..))",returning = "result")
    public void afterReturnDemo(JoinPoint joinPoint, List<Account> result){
        System.out.println("\n"+joinPoint.getSignature().toShortString());
        System.out.println("\n"+result+"\n");

        for (Account i: result) {
            String name = i.getName().toUpperCase();
            i.setName(name);
        }
    }

    @Before("execution(public * com.akhilesh.dao.MembershipDAO.addMember(*,*))")
    public void declarationWithJoinPointsOnAddMember(JoinPoint joinPoint){
        
        //Getting Method Signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("This is the method signature " + methodSignature);

        System.out.println("\n--------------------------------\n");

        //Getting Arguments
        Object[] arguments = joinPoint.getArgs();
        for (Object i : arguments) {
            System.out.println(i);

            /*
            Downcast to get specific fields from the object Account
            https://www.codejava.net/java-core/the-java-language/what-is-upcasting-and-downcasting-in-java

            if(i instanceof Account){
                Account account = (Account) i;
                System.out.println(account.getAge());
            }
             */
        }

        System.out.println("\n--------------------------------\n");
    }

    @Pointcut("execution(public void com.akhilesh.dao.AccountDAO.addAccount(com.akhilesh.pojo.Account))")
    public void pointcutDeclarations(){  }

    @Before("pointcutDeclarations()")
    public void beforeAddAccountAdvice(){
        System.out.println(">>>>>>>>>Aspect advice from "+getClass());
    }

    @Pointcut("execution(public * com.akhilesh.pojo.Account.get*())")
    public void pointcutGetter(){ }

    @Pointcut("execution(public * com.akhilesh.pojo.Account.set*(*))")
    public void pointcutSetter(){ }

    @Before("pointcutGetter() || pointcutSetter()")
    public void forEveryGetter(){
        System.out.println("here pointcut expressions are combined");
    }
}