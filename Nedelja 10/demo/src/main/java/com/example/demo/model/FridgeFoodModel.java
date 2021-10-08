package com.example.demo.model;

public class FridgeFoodModel {
    int fridge_id, food_id;
    double mass;

    public FridgeFoodModel(int fridge_id, int food_id, double mass) {
        this.fridge_id = fridge_id;
        this.food_id = food_id;
        this.mass = mass;
    }

    public int getFridge_id() {
        return fridge_id;
    }

    public int getFood_id() {
        return food_id;
    }

    public double getMass() {
        return mass;
    }
}
