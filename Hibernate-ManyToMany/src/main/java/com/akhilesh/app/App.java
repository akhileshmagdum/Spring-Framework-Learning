package com.akhilesh.app;

import com.akhilesh.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        try(factory; Session session = factory.getCurrentSession()){
            session.beginTransaction();

            Instructor dbInstructor = new Instructor("Akhilesh","Magdum","akhilesh@duck.com");
            InstructorDetail dbDetail = new InstructorDetail("Akhilesh","Cycling");
            dbInstructor.setInstructorDetail(dbDetail);

            session.save(dbInstructor);

            Course dbCourse = new Course("How to Crack a Interview",dbInstructor);
            Course dbCourse1 = new Course("How to prepare for SSB",dbInstructor);
            dbCourse.addReview(new Review("Nice Course I got placed in 4 companies"));
            dbCourse.addReview(new Review("Has the instructor ever cracked a interview?"));
            dbCourse.addReview(new Review("Need refund started working in my Dad's shop... lol"));
            dbCourse1.addReview(new Review("Thanks got recommended"));

            session.save(dbCourse);
            session.save(dbCourse1);

            Student dbStudent = new Student("Amol","Yamgar","yamgar@ry.com");
            Student dbStudent1 = new Student("Purva","Magdum","purva@duck.com");
            dbStudent.addCourse(dbCourse);
            dbStudent.addCourse(dbCourse1);
            dbStudent1.addCourse(dbCourse);

            session.save(dbStudent);
            session.save(dbStudent1);

            session.getTransaction().commit();
        }
    }
}
