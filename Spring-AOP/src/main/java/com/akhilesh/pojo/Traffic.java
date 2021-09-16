package com.akhilesh.pojo;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Traffic {

    public String getDelay(){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "You will be late!";
    }

    public String getDelay(boolean b) {
        if(b){
            throw new RuntimeException("This is manual error");
        }
        return getDelay();
    }
}
