package com.akhilesh.hibernatecode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();

            //Approach 1
            session.createQuery("delete from Student where id=4").executeUpdate();

            //Approach 2
            int deletionId = 5;
            Student deleteStudent = session.get(Student.class,deletionId);
            session.delete(deleteStudent);

            session.getTransaction().commit();
            session.close();
        }finally {
            factory.close();
        }
    }
}
