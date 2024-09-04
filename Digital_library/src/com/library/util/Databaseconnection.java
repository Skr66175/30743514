package com.library.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Databaseconnection {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Load the JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                
                String dbURL = "jdbc:mysql://localhost:3306/digital_library";
                String username = "root";
                String password = "12345";

                // Establish the connection
                connection = DriverManager.getConnection(dbURL, username, password);
            } catch (ClassNotFoundException e) {
                System.err.println("JDBC Driver not found: " + e.getMessage());
            } catch (SQLException e) {
                System.err.println("Error establishing connection: " + e.getMessage());
            }
        }
        return connection;
    }

    // Main method for testing the connection
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Connection to the database established successfully!");
            try {
                // Close the connection after testing
                conn.close();
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        } else {
            System.err.println("Failed to establish connection to the database.");
        }
    }
}
