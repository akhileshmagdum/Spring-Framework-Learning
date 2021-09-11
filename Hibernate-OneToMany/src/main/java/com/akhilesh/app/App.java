package com.akhilesh.app;

import com.akhilesh.entity.Course;
import com.akhilesh.entity.Instructor;
import com.akhilesh.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;

public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            //createInstructor(session);
            session.beginTransaction();
            int id = 1;
            Instructor instructor = session.get(Instructor.class,id);
            Course course = new Course("How to crack a Interview");
            Course course1 = new Course("Competitive Programming");
            instructor.add(course);
            instructor.add(course1);
            session.save(course);
            session.save(course1);
            session.getTransaction().commit();
        }finally {
            factory.close();
            session.close();
        }
    }

    private static void createInstructor(Session session) {
        session.beginTransaction();

        Instructor tempInstructor = new Instructor("Jay","Kapoor","jay24@duck.com");
        InstructorDetail detail = new InstructorDetail("Jay Kapoor","Reading Books");
        tempInstructor.setInstructorDetail(detail);
        session.save(tempInstructor);
        session.getTransaction().commit();
    }
}
