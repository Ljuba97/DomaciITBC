package com.example.demo.model.request;

public class RegisterRequestModel {
    private int id;
    private String username, password, email;
    private boolean admin;

    public RegisterRequestModel(int id, String username, String password, String email, boolean admin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAdmin() {
        return admin;
    }
}
