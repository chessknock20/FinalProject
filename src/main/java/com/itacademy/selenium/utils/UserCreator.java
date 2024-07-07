package com.itacademy.selenium.utils;

import com.itacademy.selenium.model.User;

public class UserCreator {

    public static final String USER_NAME = "chessknock20@gmail.com";
    public static final String USER_PASSWORD = "110v354m";

    public static User withCredentials(){
        return new User(USER_NAME, USER_PASSWORD);
    }

    public static User withWrongCredentials(){
        return new User("wronglogin", "wrongpassword");
    }

    public static User withEmptyUsername(){
        return new User("", USER_PASSWORD);
    }

    public static User withEmptyPassword(){
        return new User(USER_NAME, "");
    }
    public static User withEmptyCredentials(){
        return new User("", "");
    }
}

