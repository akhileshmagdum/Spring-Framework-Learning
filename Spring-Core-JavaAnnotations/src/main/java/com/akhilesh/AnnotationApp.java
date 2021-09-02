package com.akhilesh;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach theCoach = context.getBean("Jonas",Coach.class);
        System.out.println(theCoach.getWorkout());
        context.close();
    }
}
