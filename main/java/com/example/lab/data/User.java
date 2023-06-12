package com.example.lab6_1.data;

public class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String get_name() {
        return this.name;
    }

    public String get_email() {
        return this.email;
    }
}
