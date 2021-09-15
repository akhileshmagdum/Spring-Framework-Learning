package com.akhilesh.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public String addMember(){
        return "From class "+getClass();
    }
}
