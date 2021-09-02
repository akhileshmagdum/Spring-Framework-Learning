package com.akhilesh;

public class FootballCoach implements Coach{

    //Private field for dependency Injection
    private FortuneService fortuneService;

    //Constructor for dependency Injection
    public FootballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout(){
        return "Practice kicking";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.myFortuneService();
    }
}
