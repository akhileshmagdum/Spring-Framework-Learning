package com.akhilesh;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        Coach theCoach = applicationContext.getBean("runCoach",Coach.class);
        System.out.println(theCoach.getWorkout());
    }
}
