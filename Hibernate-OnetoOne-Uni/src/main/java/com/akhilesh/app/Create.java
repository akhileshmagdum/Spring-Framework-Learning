package com.akhilesh.app;

import com.akhilesh.entity.Instructor;
import com.akhilesh.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Create {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Instructor instructor = new Instructor("Sam","Kolder","sam@kold.com");
            InstructorDetail detail = new InstructorDetail("Kold","Exercise");
            instructor.setInstructorDetail(detail);

            session.beginTransaction();
            //This is also saves the details as cascade is set to all
            session.save(instructor);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
