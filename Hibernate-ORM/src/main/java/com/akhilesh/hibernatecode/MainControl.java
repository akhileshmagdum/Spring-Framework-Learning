package com.akhilesh.hibernatecode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class MainControl {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        System.out.println("Database Insertion for hbstudent\n"+
                "1.Create\n2.Read\n3.Update\n4.Delete\n5.Show All");
        int operation = scan.nextInt();

        switch (operation){
            case 1:
                System.out.print("Enter First Name: ");
                String firstName = scan.nextLine();
                scan.nextLine();
                System.out.print("Enter Last Name: ");
                String lastName = scan.nextLine();
                System.out.print("Enter Email-id: ");
                String email = scan.nextLine();
                Student student = new Student(firstName,lastName,email);
                session.beginTransaction();
                session.save(student);
                session.getTransaction().commit();
                session.close();
                break;
            case 2:
                session = factory.getCurrentSession();
                session.beginTransaction();
                System.out.print("Enter id: ");
                int id = scan.nextInt();
                Student getStudentFromDB = session.get(Student.class,id);
                System.out.println(getStudentFromDB);
                session.getTransaction().commit();
                break;
            case 3:
                //Code for update {Needed another switch or if else ladder}
                break;
            case 4:
                session = factory.getCurrentSession();
                session.beginTransaction();
                System.out.print("Enter id: ");
                int iddel = scan.nextInt();
                Student StudentFromDB = session.get(Student.class,iddel);
                session.delete(StudentFromDB);
                session.getTransaction().commit();
                break;
            case 5:
                session.beginTransaction();
                List<Student> studentList = session.createQuery("from Student").getResultList();
                displayStudents(studentList);
                break;
        }
    }
    private static void displayStudents(List<Student> studentList) {
        for (Student i : studentList) {
            System.out.println(i);
        }
    }
}
