package com.akhilesh;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach{

    @Autowired
    @Qualifier("randomService")
    private FortuneService fortuneService;

    @PostConstruct
    public void postConstructing(){
        System.out.println("This is post construct method at work");
    }

    @PreDestroy
    public void destroying(){
        System.out.println("Destroying demo");
    }


    @Override
    public String getWorkout() {
        return "Practice the service";
    }

    @Override
    public String getFortune() {
        return fortuneService.getFortuneService();
    }
}
