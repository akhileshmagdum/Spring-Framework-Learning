package com.akhilesh;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.akhilesh") //works like xml configuration
public class Config {

    @Bean
    public FortuneService testFortune(){
        return new TestFortuneService();
    }

    @Bean
    public Coach runner(){
        return new RunCoach(testFortune());
    }
}
