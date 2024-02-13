package com.example.demo.dao;

import com.example.demo.model.User;

public interface Jdbc {

    User createUser(User user);
    User insert(User user);
    User getUser(Long id);
    void deleteUser(User user);
}
