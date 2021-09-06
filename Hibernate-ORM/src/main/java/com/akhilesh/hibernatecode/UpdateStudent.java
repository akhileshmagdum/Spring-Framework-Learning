package com.akhilesh.hibernatecode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            int studentid = 5;
            session.beginTransaction();
            Student updateStudent = session.get(Student.class,studentid);
            updateStudent.setLastName("Jagtap");
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
