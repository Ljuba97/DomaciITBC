package com.example.demo.model;

public class FoodModel {
    private int food_id;
    private String food_name;
    private double food_kcal, food_proteins, food_carbohydrates, food_fat;

    public FoodModel(int food_id, String food_name, double food_kcal, double food_proteins, double food_carbohydrates, double food_fat) {
        this.food_id = food_id;
        this.food_name = food_name;
        this.food_kcal = food_kcal;
        this.food_proteins = food_proteins;
        this.food_carbohydrates = food_carbohydrates;
        this.food_fat = food_fat;
    }

    public int getFood_id() {
        return food_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public double getFood_kcal() {
        return food_kcal;
    }

    public double getFood_proteins() {
        return food_proteins;
    }

    public double getFood_carbohydrates() {
        return food_carbohydrates;
    }

    public double getFood_fat() {
        return food_fat;
    }
}
