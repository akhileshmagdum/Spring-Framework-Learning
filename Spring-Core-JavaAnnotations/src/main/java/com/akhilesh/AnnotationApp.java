package com.akhilesh;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach theCoach = context.getBean("tennisCoach",Coach.class); //Default Bean id is used

        System.out.println(theCoach.getFortune());
        context.close();
    }
}
