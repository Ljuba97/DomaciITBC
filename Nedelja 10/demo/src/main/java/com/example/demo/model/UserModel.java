package com.example.demo.model;

public class UserModel {
    private int userId;
    private String userName, email, password;
    private boolean admin;

    public UserModel(int userId, String userName, String email, String password, boolean admin) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.admin = admin;
    }

    public UserModel(UserModel user) {
        this.userId = user.userId;
        this.userName = user.userName;
        this.email = user.email;
        this.password = user.password;
        this.admin = user.admin;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return admin;
    }
}
