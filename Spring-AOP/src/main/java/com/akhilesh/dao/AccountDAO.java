package com.akhilesh.dao;

import com.akhilesh.pojo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    public void addAccount(Account account){
        System.out.println("Account code from "+ getClass());
    }

    public List<Account> findAccounts(boolean testing){
        if(testing){
            throw new RuntimeException("This is for testing purpose");
        }
        System.out.println("From Find Class");
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("Akhilesh","akhilesh@duck.com",11));
        return accounts;
    }
}
