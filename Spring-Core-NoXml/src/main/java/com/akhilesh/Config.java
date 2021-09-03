package com.akhilesh;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.akhilesh") //works like xml configuration
@PropertySource("classpath:coached.properties")
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
