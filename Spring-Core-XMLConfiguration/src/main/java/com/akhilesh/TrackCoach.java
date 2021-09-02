package com.akhilesh;

public class TrackCoach implements Coach {

    @Override
    public String getDailyWorkout(){
        return "Run 5km daily";
    }

    @Override
    public String getDailyFortune() {
        return "Good day Player!";
    }
}
