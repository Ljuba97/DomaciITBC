package com.example.demo.model.response;

public class FridgeResponseModel {
    private boolean successful;
    private String message;

    public FridgeResponseModel(boolean successful, String message) {
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
