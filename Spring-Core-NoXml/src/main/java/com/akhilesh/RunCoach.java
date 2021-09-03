package com.akhilesh;

import org.springframework.stereotype.Component;

@Component
public class RunCoach implements Coach{
    @Override
    public String getWorkout() {
        return "Run 20 km";
    }
}
