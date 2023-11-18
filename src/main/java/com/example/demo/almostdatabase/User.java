package com.example.demo.almostdatabase;

public class User {
    private String login;
    private String password;

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

public String getLogin(){
        return login;
}

public String getPassword(){
        return password;
}

public void setLogin(String login){ //это вообще имеет смысл, если логин-ключ? TT
        this.login = login;
}

public void setPassword(String password){
        this.password = password;
}
}
