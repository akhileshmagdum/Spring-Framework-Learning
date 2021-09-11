package com.akhilesh.hibernatecode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudent {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            List<Student> studentList = session.createQuery("from Student").getResultList();
            displayStudents(studentList);
            //Getting students with @duck mail
            List<Student> duckStudents = session.createQuery("from Student s where s.email LIKE '%duck.com'")
                    .getResultList();
            System.out.println("\n\n\nStudents with Duck Mail id\n");
            displayStudents(duckStudents);
            session.getTransaction().commit();
            session.close();

        }finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> studentList) {
        for (Student i : studentList) {
            System.out.println(i);
        }
    }
}
