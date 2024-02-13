package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {


    /*
     *
     *  Создание таблицы для юзеров — не должно приводить к исключению, если такая таблица уже существует
     *Удаление таблицы юзеров — не должно приводить к исключению, если таблицы не существует
     *Очистка содержания таблицы
     *Добавление User в таблицу
     *Удаление User из таблицы (по id)
     *Получение всех юзеров из таблицы
     * */
    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

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
