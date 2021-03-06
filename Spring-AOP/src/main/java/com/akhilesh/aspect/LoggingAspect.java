package com.akhilesh.aspect;

import com.akhilesh.pojo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(public * com.akhilesh.pojo.Traffic.getDelay(..))")
    public Object aroundDemo(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        System.out.println("AROUND on "+proceedingJoinPoint.getSignature().toShortString());

        long start = System.currentTimeMillis();
        Object obj = null;
        try {
            obj = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println("We have "+e);

            throw e;
        }

        long end = System.currentTimeMillis();

        long duration = end - start;
        System.out.println(duration/1000);

        return obj;
    }

    /*
   The @After Advice is running AFTER the @AfterThrowing advice.
   Starting with Spring 5.2.7:
   - if advice methods defined in the same @Aspect class that need to run at the same join point
   - the @After advice method is invoked AFTER any @AfterReturning or @AfterThrowing advice methods in the same aspect class
     */

    @After("execution(public * com.akhilesh.dao.AccountDAO.findAccounts(..))")
    public void afterDemo(){
        System.out.println("From @After "+getClass());
    }

    @AfterThrowing(pointcut = "execution(public * com.akhilesh.dao.AccountDAO.findAccounts(..))",throwing = "exc")
    public void afterThrowingDemo(Throwable exc){
        System.out.println("From Aspect @afterthrowing "+getClass()+" \n"+ exc);
    }

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