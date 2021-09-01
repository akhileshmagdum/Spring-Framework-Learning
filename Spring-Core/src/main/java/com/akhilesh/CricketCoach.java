package com.akhilesh;

public class CricketCoach implements Coach{

    private FortuneService fortuneService;
<<<<<<< HEAD
    private String teamName;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
=======
>>>>>>> 1a230a9c37a04d6579ca1e691d6048ce70ef2c4d

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
