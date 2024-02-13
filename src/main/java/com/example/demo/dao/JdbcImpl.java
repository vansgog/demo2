package com.example.demo.dao;

import com.example.demo.config.JdbcConnector;
import com.example.demo.config.JdbcConnectorImpl;
import com.example.demo.model.User;

public class JdbcImpl implements Jdbc {

    private final JdbcConnector jdbc = new JdbcConnectorImpl();



    @Override
    public User createUser(User user) {

       return user;
    }

    @Override
    public User insert(User user) {
        return user;
    }

    @Override
    public User getUser(Long id) {

        return new User();
    }

    @Override
    public void deleteUser(User user) {

    }

}
