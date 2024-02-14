package com.example.demo.dao;

import com.example.demo.Util.JdbcConnector;
import com.example.demo.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcImpl implements Jdbc {
    /*
     * Реализовать методы
     * Используем commit, rollback
     * service переиспользует методы dao
     * Обработка всех исключений, связанных с работой с базой данных должна находиться в dao
     * */
    private final Connection connection = JdbcConnector.getConnection();
    private static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS users" +
                                            "(id SERIAL PRIMARY KEY, " +
                                            "firstName VARCHAR(20), " +
                                            "lastName VARCHAR(30))";
    private static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS users";
    private static final String INSERT_USER_QUERY = "INSERT INTO users (firstName, lastName) VALUES (?, ?)";
    private static final String DELETE_USER_QUERY = "DELETE FROM users WHERE id = ?";
    private static final String GET_ALL_USERS_QUERY = "SELECT * FROM users";
    private static final String CLEAN_TABLE_QUERY = "DELETE FROM users";


    public JdbcImpl() throws SQLException {
    }

    @Override
    public void createUsersTable() {
        try (Statement statement = connection.createStatement()){
            connection.setAutoCommit(false);
            connection.commit();
            statement.executeUpdate(CREATE_TABLE_QUERY);
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        try (Statement statement = connection.createStatement()){
            connection.setAutoCommit(false);
            connection.commit();
            statement.executeUpdate(DROP_TABLE_QUERY);
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_QUERY)) {
            connection.setAutoCommit(false);
            connection.commit();
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.executeUpdate();
            System.out.println("User с именем " + name + " " + lastName + " добавлен в базу");
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_QUERY)) {
            connection.setAutoCommit(false);
            connection.commit();
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_USERS_QUERY)) {
            connection.setAutoCommit(false);
            connection.commit();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");

                User user = new User(id, name, lastName);
                users.add(user);
            }
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        try (Statement statement = connection.createStatement()){
            connection.setAutoCommit(false);
            connection.commit();
            statement.executeUpdate(CLEAN_TABLE_QUERY);
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}