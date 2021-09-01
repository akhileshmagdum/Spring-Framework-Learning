package com.akhilesh;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        CricketCoach cricketCoach = context.getBean("myCricketCoach",CricketCoach.class);
        System.out.println(cricketCoach.getDailyFortune()+" "+cricketCoach.getDailyWorkout()+" "+ cricketCoach.getTeamName());

        context.close();
    }
}
