package com.akhilesh;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RunCoach implements Coach{

    @Value("${coach.name}")
    private String name;

    FortuneService fortuneService;

    public RunCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getWorkout() {
        return "Run 20 km";
    }

    @Override
    public String getFortuneService() {
        return fortuneService.getFortune();
    }
}
