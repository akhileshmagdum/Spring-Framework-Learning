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

//            Course course = session.get(Course.class,11);
//            session.delete(course);

            Student student = session.get(Student.class,2);
            session.delete(student);

            session.getTransaction().commit();
        }
    }
}
