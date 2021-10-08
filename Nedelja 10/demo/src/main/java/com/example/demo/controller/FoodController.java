package com.example.demo.controller;

import com.example.demo.dao.FoodDaoSQL;
import com.example.demo.model.FoodModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {
    private static final FoodDaoSQL fd = new FoodDaoSQL();

    @GetMapping("/food/{id}")
    public FoodModel getFoodById(@PathVariable("id") int foodId) {
        return fd.getFood(foodId);
    }

    @GetMapping("/food")
    public List<FoodModel> getFood() {
        return fd.getAllFood();
    }
}
