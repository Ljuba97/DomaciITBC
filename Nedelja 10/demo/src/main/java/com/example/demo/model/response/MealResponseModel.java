package com.example.demo.model.response;

import java.util.List;

public class MealResponseModel {
    private String name;
    private double kcal;
    private List<String> foodNames;

    public MealResponseModel(String name, double kcal, List<String> foodNames) {
        this.name = name;
        this.kcal = kcal;
        this.foodNames = foodNames;
    }

    public String getName() {
        return name;
    }

    public double getKcal() {
        return kcal;
    }

    public List<String> getFoodNames() {
        return foodNames;
    }
}
