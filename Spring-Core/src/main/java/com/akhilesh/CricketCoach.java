package com.akhilesh;

public class CricketCoach implements Coach{

    private FortuneService fortuneService;

    public CricketCoach(){ }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "More batting practice";
    }

    @Override
    public String getDailyFortune() {
        return "You will win the tose";
    }
}
