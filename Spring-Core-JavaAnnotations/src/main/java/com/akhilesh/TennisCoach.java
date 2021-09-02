package com.akhilesh;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    private FortuneService fortuneService;

    @Autowired
    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
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
