package com.akhilesh;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component("Jonas")
public class TennisCoach implements Coach{
    @Override
    public String getWorkout() {
        return "Practice the service";
    }
}
