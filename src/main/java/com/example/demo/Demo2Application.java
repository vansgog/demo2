package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;

import java.util.List;

public class Demo2Application {

    public static void main(String[] args) {
        /*
         * Создание таблицы юзеров
         *Добавление 4 юзеров в таблицу с данными на свой выбор. После каждого добавления должен быть вывод в консоль (User с именем — name добавлен в базу данных)
         *Получение всех User из базы и вывод в консоль (должен быть переопределен toString в классе User)
         *Очистка таблицы юзеров
         *Удаление таблицы
         *
         * */
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Вася", "Пупкин");
        userService.saveUser("Пупка", "Васин");
        userService.saveUser("Пуся", "Вапкин");
        userService.saveUser("Магомед", "Магомедов");

        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }

}
