package com.akhilesh.aop;

import com.akhilesh.dao.AccountDAO;
import com.akhilesh.dao.MembershipDAO;
import com.akhilesh.pojo.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Account account = new Account("akhilesh","magdum",22);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        accountDAO.addAccount(account);
        System.out.println("///////////////////////////////////");
        MembershipDAO membershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
        System.out.println(membershipDAO.addMember());

        context.close();
    }
}
