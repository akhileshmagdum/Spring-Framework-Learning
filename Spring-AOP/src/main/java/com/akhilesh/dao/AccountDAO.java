package com.akhilesh.dao;

import com.akhilesh.pojo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account account){
        System.out.println("Account code from "+ getClass());
    }
}
