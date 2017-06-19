package com.ex.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionUtil {
    static{
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection newConnection(String url, String username, String password) throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
