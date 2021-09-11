package com.akhilesh.hibernatecode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudent {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            Student student = new Student("Vijay","Sharma","vijay@sharma.com");
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println(" "+student.getId());
            Student getStudentFromDB = session.get(Student.class,student.getId());
            System.out.println(getStudentFromDB);
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
