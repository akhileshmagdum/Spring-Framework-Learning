package com.akhilesh.aop;

import com.akhilesh.dao.AccountDAO;
import com.akhilesh.dao.MembershipDAO;
import com.akhilesh.pojo.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        context.close();
    }
}
