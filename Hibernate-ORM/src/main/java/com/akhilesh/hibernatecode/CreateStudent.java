package com.akhilesh.hibernatecode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudent {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            Student student = new Student("Akhilesh","Magdum","akhilesh@duck.com");
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            System.out.println(student+" ADDED IN TABLE");
        }
        finally {
            factory.close();
        }
    }
}
