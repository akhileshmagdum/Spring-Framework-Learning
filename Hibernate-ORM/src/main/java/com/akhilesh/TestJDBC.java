package com.akhilesh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {
    public static void main(String[] args) {
        String jdbcurl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String usernamePassword ="hbstudent";


        try {
            Connection connection = DriverManager.getConnection(jdbcurl,usernamePassword,usernamePassword);
            System.out.println("Connection established");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
