package com.example.demo.dao;

import com.example.demo.Util.JdbcConnector;
import com.example.demo.model.User;

import java.sql.Connection;
import java.util.List;

public class JdbcImpl implements Jdbc {
    /*
     * Реализовать методы
     * Используем commit,rollback
     *service переиспользует методы dao
     *Обработка всех исключений, связанных с работой с базой данных должна находиться в dao
     * */
    private final Connection connection = JdbcConnector.getConnection();

    public JdbcImpl() {
    }

    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName) {

    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }

}
