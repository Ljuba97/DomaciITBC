package com.example.demo.model.request;

import java.util.List;

public class MealRequestModel {
    private int id;
    private String name, description, difficulty;
    private List<String> foodNames;

    public MealRequestModel(int id, String name, String description, String difficulty) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDifficulty() {
        return difficulty;
    }
}
