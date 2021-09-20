package com.akhilesh.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {
    public static void main(String[] args) {
        Connection conn;
        {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_security_demo_plaintext?useSSL=false"
                        ,"hbstudent","hbstudent");
                System.out.println("Connection established");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
