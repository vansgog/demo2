package com.example.demo.model;

public class User {

    private Long id;
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return id + ": " + firstName + " " + lastName;
    }
}
