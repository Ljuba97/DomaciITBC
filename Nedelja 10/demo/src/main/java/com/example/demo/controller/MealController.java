package com.example.demo.controller;

import com.example.demo.dao.MealDaoSQL;
import com.example.demo.model.request.MealRequestModel;
import com.example.demo.model.response.MealResponseModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MealController {
    private static final MealDaoSQL md = new MealDaoSQL();

    @GetMapping("/meals")
    public List<MealRequestModel> getAllMeals() {
        return md.getAllMeals();
    }

    @GetMapping("/meals/search/{name}&{kcal}")
    public List<MealRequestModel> searchMeals(@PathVariable("name") String mealName, @PathVariable("kcal") double kcal) {
        return md.searchMeal(mealName.toLowerCase(), kcal);
    }

    @PostMapping("/meals/search")
    public List<MealResponseModel> searchMealsAndFood() {
        return md.searchMealsAndFood();
    }
}
