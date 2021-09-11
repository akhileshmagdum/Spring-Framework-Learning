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

            Instructor newInstructor = new Instructor("Michael","Scott","manager@dmi.com");
            newInstructor.setInstructorDetail(new InstructorDetail("Electric Scranton","humor"));
            session.save(newInstructor);

            Student student = session.get(Student.class,2);
            Course newCourse = new Course("Dancing 101",newInstructor);
            student.addCourse(newCourse);
            session.save(newCourse);

            session.getTransaction().commit();
        }
    }
}
