package com.example.demo.config;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectorImpl implements JdbcConnector {

    private final String uri = "";
    private final String userName = "";
    private final String password = "";


    public Connection connection(){
        try {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection con = DriverManager.getConnection(uri,userName,password)) {
                con.setAutoCommit(false);
                return con;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                 ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
