package com.example.demo.service;

import com.example.demo.dao.Jdbc;
import com.example.demo.dao.JdbcImpl;
import com.example.demo.model.User;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class UserServiceImpl implements UserService {
    /*
     * Создание таблицы для юзеров — не должно приводить к исключению, если такая таблица уже существует
     * Удаление таблицы юзеров — не должно приводить к исключению, если таблицы не существует
     * Очистка содержания таблицы
     * Добавление User в таблицу
     * Удаление User из таблицы (по id)
     * Получение всех юзеров из таблицы
     * */
    private final Jdbc jdbc = new JdbcImpl();

    public UserServiceImpl() throws SQLException {
    }

    @Override
    public void createUsersTable() {
        jdbc.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        jdbc.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName) {
        jdbc.saveUser(name, lastName);
    }

    @Override
    public void removeUserById(long id) {
        if (jdbc.getAllUsers().contains(id)) {
            jdbc.removeUserById(id);
        } else System.out.println("No such user");
    }

    @Override
    public List<User> getAllUsers() {
        if (jdbc.getAllUsers().isEmpty()) {
            System.out.println("No users found");
            return Collections.emptyList();
        } else return jdbc.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        if (!jdbc.getAllUsers().isEmpty()) {
            jdbc.cleanUsersTable();
        } else System.out.println("No users to clear");
    }
}