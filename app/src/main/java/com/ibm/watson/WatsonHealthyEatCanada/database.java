package com.ibm.watson.WatsonHealthyEatCanada;

/**
 * Created by Matthew on 2015-05-14.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
    Class.forName("com.mysql.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/javabase";
    String username = "java";
    String password = "d$7hF_r!9Y";
    Connection connection = null;
    try {
        System.out.println("Connecting database...");
        connection = DriverManager.getConnection(url, username, password);
        System.out.println("Database connected!");
    } catch (SQLException e){
    } throw new RuntimeException("Cannot connect the database!", e);
    }finally {
        System.out.println("Closing the connection.");
        if (connection != null) try {
            connection.close();
        } catch (SQLException ignore) {
        }
    }
}