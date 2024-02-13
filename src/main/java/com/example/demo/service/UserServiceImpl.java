package com.example.demo.service;

import com.example.demo.dao.Jdbc;
import com.example.demo.dao.JdbcImpl;
import com.example.demo.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    /*
     *  Создание таблицы для юзеров — не должно приводить к исключению, если такая таблица уже существует
     *Удаление таблицы юзеров — не должно приводить к исключению, если таблицы не существует
     *Очистка содержания таблицы
     *Добавление User в таблицу
     *Удаление User из таблицы (по id)
     *Получение всех юзеров из таблицы
     * */

    private final Jdbc jdbc = new JdbcImpl();

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
        System.out.println("User с именем " + name + " " + lastName + " добавлен в базу");
    }

    @Override
    public void removeUserById(long id) {
        jdbc.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return jdbc.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        jdbc.cleanUsersTable();
    }
}
