package com.example.demo.controller;

import com.example.demo.dao.FoodDaoSQL;
import com.example.demo.dao.FridgeDaoSQL;
import com.example.demo.dao.FridgeFoodDaoSQL;
import com.example.demo.model.FoodModel;
import com.example.demo.model.FridgeFoodModel;
import com.example.demo.model.FridgeModel;
import com.example.demo.model.request.FridgeFoodRequestModel;
import com.example.demo.model.response.FridgeResponseModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class FridgeController {
    private static final FridgeDaoSQL fd = new FridgeDaoSQL();
    private static final FridgeFoodDaoSQL ffd = new FridgeFoodDaoSQL();
    private static final FoodDaoSQL food = new FoodDaoSQL();

    @GetMapping("/my-fridge/{id}")
    public List<FridgeFoodRequestModel> getFridgeFood(@PathVariable("id") int fridgeId) {
        return fd.getAllFridgeFood(fridgeId);
    }

    @PostMapping("my-fridge/{id}")
    public FridgeResponseModel addFridgeFood(@RequestBody FridgeFoodRequestModel fridge, @PathVariable("id") int fridgeId) {
        Random r = new Random();
        int br = r.nextInt(1000);
        List<Integer> list = new ArrayList<>();
        String message = "";
        boolean flag = false;

        for (var x : food.getAllFood()) {
            if (x.getFood_name().equals(fridge.getName())) {
                flag = true;
                br = x.getFood_id();
                break;
            }
            list.add(x.getFood_id());
        }

        if (!flag) {
            while (list.contains(br))
                br = r.nextInt(1000);

            food.add(new FoodModel(br, fridge.getName(), fridge.getKcal(), fridge.getProteins(), fridge.getCarbohydrates(), fridge.getFat()));
        }

        for (var x : ffd.getAllFridges()) {
            if (x.getFridge_id() == fridgeId && x.getFood_id() == br) {
                message = message.concat("Food already exists in fridge!");
                break;
            }
        }
        food.addToFridge(fridgeId, br, fridge.getMass());
        if (message.isEmpty())
            return new FridgeResponseModel(true, "Food successfully added to fridge!");
        else
            return new FridgeResponseModel(true, message.concat(" Mass for this food updated in fridge!"));

    }

    @DeleteMapping("/my-fridge")
    public FridgeResponseModel deleteFromFridge(@RequestParam("id") int id, @RequestParam("mass") double mass) {
        if (mass >= ffd.getMassById(id)) {
            ffd.delete(id);
            return new FridgeResponseModel(true, "Food successfully removed from fridge!");
        }
        ffd.update(id, mass);
        return new FridgeResponseModel(true, "Mass of specified food successfully reduced from fridge!");
    }
}
