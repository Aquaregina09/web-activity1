package com.bootcamp.hr.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.bootcamp.hr.AppConfiguration;

public class DatabaseConnectionManager {
    private Connection connection;

    public DatabaseConnectionManager() {
        try {
            Class.forName(AppConfiguration.getString("jdbc.driver"));
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC driver not found.");
        }
    }

    public Connection getConnection() throws SQLException {

        connection = DriverManager.getConnection(AppConfiguration.getString("jdbc.url"),
                                                 AppConfiguration.getString("jdbc.username"),
                                                 AppConfiguration.getString("jdbc.password"));
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
