package com.akhilesh.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {
    public static void main(String[] args) {
        String jdbcurl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
        String usernamePassword ="hbstudent";


        try {
            Connection connection = DriverManager.getConnection(jdbcurl,usernamePassword,usernamePassword);
            System.out.println("Connection established");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
