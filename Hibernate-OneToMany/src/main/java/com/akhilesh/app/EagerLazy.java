package com.akhilesh.app;

import com.akhilesh.entity.Course;
import com.akhilesh.entity.Instructor;
import com.akhilesh.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazy {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        try (factory; Session session = factory.getCurrentSession()) {
            //createInstructor(session);
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, 1);
            System.out.println(instructor);
            System.out.println(instructor.getCourseList());
            session.getTransaction().commit();
        }
    }
}
