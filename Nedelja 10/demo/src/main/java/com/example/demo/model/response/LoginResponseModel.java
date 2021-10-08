package com.example.demo.model.response;

import java.util.UUID;

public class LoginResponseModel {
    private boolean successful;
    private int userId;

    public LoginResponseModel(boolean successful, int userId) {
        this.successful = successful;
        this.userId = userId;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public int getUserId() {
        return userId;
    }
}
