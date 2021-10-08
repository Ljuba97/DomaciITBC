package com.example.demo.model.request;

public class LoginRequestModel {
    private String identification;
    private String password;

    public LoginRequestModel(String identification, String password) {
        this.identification = identification;
        this.password = password;
    }

    public String getIdentification() {
        return identification;
    }

    public String getPassword() {
        return password;
    }
}
