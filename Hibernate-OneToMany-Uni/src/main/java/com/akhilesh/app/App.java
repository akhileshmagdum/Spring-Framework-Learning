package com.akhilesh.app;

import com.akhilesh.entity.Course;
import com.akhilesh.entity.Instructor;
import com.akhilesh.entity.InstructorDetail;
import com.akhilesh.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        try (factory; Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            Course course = session.get(Course.class,10);
            System.out.println(course);
            System.out.println(course.getReviewList());

//            Course tempCourse = new Course("Cycling");
//            tempCourse.add(new Review("This was a nice course"));
//            tempCourse.add(new Review("I know how to paddle"));
//
//            session.save(tempCourse);

            session.getTransaction().commit();
        }
    }
}
