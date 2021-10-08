package com.example.demo.model.response;

public class RegisterResponseModel {
    private boolean successful;
    private String message;

    public RegisterResponseModel(boolean successful, String message) {
        this.successful = successful;
        this.message = message;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public String getMessage() {
        return message;
    }
}
