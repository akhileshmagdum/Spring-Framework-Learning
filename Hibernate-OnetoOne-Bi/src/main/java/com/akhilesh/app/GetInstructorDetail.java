package com.akhilesh.app;

import com.akhilesh.entity.Instructor;
import com.akhilesh.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetail {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            int id = 1;
            InstructorDetail detail = session.get(InstructorDetail.class,id);
            System.out.println(detail);
            //Getting the associated instructor with that detail

            //Deleting the bidirectional link between Instructor and Instructor Detail
            detail.getInstructor().setInstructorDetail(null);

            //Deleting detail
            session.delete(detail);

            System.out.println(detail.getInstructor());
            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
