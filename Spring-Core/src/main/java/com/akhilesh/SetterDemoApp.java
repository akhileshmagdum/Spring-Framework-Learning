package com.akhilesh;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        CricketCoach cricketCoach = context.getBean("myCricketCoach",CricketCoach.class);
<<<<<<< HEAD
        System.out.println(cricketCoach.getDailyFortune()+" "+cricketCoach.getDailyWorkout()+" "+ cricketCoach.getTeamName());

=======
        System.out.println(cricketCoach.getDailyFortune()+" "+cricketCoach.getDailyWorkout());
>>>>>>> 1a230a9c37a04d6579ca1e691d6048ce70ef2c4d
        context.close();
    }
}
