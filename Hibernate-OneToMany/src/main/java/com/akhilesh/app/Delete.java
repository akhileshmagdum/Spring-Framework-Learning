package com.akhilesh.app;

import com.akhilesh.entity.Course;
import com.akhilesh.entity.Instructor;
import com.akhilesh.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Delete {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Course deleteCourse = session.get(Course.class,11);
            session.delete(deleteCourse);
            session.getTransaction().commit();
        }finally {
            factory.close();
            session.close();
        }
    }
}
