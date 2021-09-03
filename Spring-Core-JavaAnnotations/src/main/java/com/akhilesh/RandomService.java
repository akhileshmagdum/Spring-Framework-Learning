package com.akhilesh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RandomService implements FortuneService{

    @Override
    public String getFortuneService() {
        return "This is really random";
    }
}
