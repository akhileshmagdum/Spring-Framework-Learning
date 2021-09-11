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
            Student student = session.get(Student.class,1);
            /*
            toString() should be created with logic make sure we won't call each other's object's two string
             */
            System.out.println("\n====================\n"+student+"\n====================\n");
            session.getTransaction().commit();
        }
    }
}
