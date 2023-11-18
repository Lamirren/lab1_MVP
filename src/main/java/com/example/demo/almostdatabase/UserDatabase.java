package com.example.demo.almostdatabase;

import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
    private static Map<String, User> users = new HashMap<>(); //ключ логин

    public static boolean addUser(User user){
        String login = user.getLogin();

        if(!users.containsKey(login)){
            users.put(user.getLogin(), user);
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkPassword(String login, String password) {
        User user = users.get(login);

        if (user != null && password.equals(user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }


}
