package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.List;

public interface Jdbc {

    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastName);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();
}