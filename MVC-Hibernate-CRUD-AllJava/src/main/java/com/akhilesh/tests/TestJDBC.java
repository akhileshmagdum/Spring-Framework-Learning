package com.akhilesh.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
        String userPass = "springstudent";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl,userPass,userPass);
            System.out.println("Connection established");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
