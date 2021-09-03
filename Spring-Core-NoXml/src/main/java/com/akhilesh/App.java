package com.akhilesh;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        Coach theCoach = applicationContext.getBean("runner",Coach.class);
        System.out.println(theCoach.getWorkout()+"\n"+theCoach.getFortuneService());
    }
}
