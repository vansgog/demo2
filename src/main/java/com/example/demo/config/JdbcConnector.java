package com.example.demo.config;

import java.sql.Connection;

public interface JdbcConnector {

    Connection connection() throws ClassNotFoundException;
}
