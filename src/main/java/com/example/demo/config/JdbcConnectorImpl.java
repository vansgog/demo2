package com.example.demo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectorImpl implements JdbcConnector {

    private final String uri = "";
    private final String userName = "";
    private final String password = "";


    public Connection connection() {
        try (Connection con = DriverManager.getConnection(uri,userName,password)) {
            con.setAutoCommit(false);
            return con;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
