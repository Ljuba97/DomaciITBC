package com.example.demo.model.request;

public class FridgeFoodRequestModel {
    private String name;
    private double kcal, proteins, carbohydrates, fat, mass;

    public FridgeFoodRequestModel(String name, double kcal, double proteins, double carbohydrates, double fat, double mass) {
        this.name = name;
        this.kcal = kcal;
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
        this.fat = fat;
        this.mass = mass;
    }

    public FridgeFoodRequestModel(double mass) {
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public double getKcal() {
        return kcal;
    }

    public double getProteins() {
        return proteins;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getFat() {
        return fat;
    }

    public double getMass() {
        return mass;
    }
}
