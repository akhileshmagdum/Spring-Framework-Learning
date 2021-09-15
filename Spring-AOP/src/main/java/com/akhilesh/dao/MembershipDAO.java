package com.akhilesh.dao;

import com.akhilesh.pojo.Account;
import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public String addMember(Account account, boolean vip){
        vip = false;
        account.setAge(22);
        account.setName("Akhilesh");
        return ("Member code from "+getClass());
    }
}
