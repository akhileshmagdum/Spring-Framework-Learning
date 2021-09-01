package com.akhilesh;

public class CricketCoach implements Coach{

    private FortuneService fortuneService;
    private String teamName;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

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
