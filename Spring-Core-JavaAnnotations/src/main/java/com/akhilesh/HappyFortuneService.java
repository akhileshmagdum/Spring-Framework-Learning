package com.akhilesh;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService{
    @Override
    public String getFortuneService() {
        return "Today is the lucky day";
    }
}
