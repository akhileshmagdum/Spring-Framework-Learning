package com.akhilesh;

import org.springframework.stereotype.Component;

@Component
public class RunCoach implements Coach{

    FortuneService fortuneService;

    public RunCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
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
