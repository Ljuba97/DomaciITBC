package com.example.demo.controller;

import com.example.demo.dao.UserDaoSQL;
import com.example.demo.model.FridgeFoodModel;
import com.example.demo.model.request.LoginRequestModel;
import com.example.demo.model.request.RegisterRequestModel;
import com.example.demo.model.response.LoginResponseModel;
import com.example.demo.model.UserModel;
import com.example.demo.model.response.RegisterResponseModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class UserController {
    private static final UserDaoSQL ud = new UserDaoSQL();

    @GetMapping("/users/{id}")
    public UserModel getUserById(@PathVariable("id") int userId) {
        return ud.getUser(userId);
    }

    @GetMapping("/users")
    public List<UserModel> getUsers() {
        return ud.getAllUsers();
    }

    /*@GetMapping("/login")
    public LoginResponseModel login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        return new LoginResponseModel(ud.login(username, password), 1);
    }*/

    //metoda koja dodaje user-a u bazu
    @PostMapping("/users")
    public UserModel addUser(@RequestBody UserModel user) {
        try {
            ud.add(user);
            return new UserModel(user);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new UserModel(-1, null, null, null, false);
    }

    @PostMapping("/login")
    public LoginResponseModel loginUser(@RequestBody LoginRequestModel info) {
        return new LoginResponseModel(ud.login(info.getIdentification(), info.getPassword()), ud.getIdByLogin(info.getIdentification(), info.getPassword()));
    }

    @PostMapping("/register")
    public RegisterResponseModel register(@RequestBody RegisterRequestModel user) {
        Random r = new Random();
        int x = r.nextInt(1000);
        List<Integer> arr = new ArrayList<>();
        for (UserModel um : ud.getAllUsers()) {
            if (um.getEmail().equals(user.getEmail()) || um.getUserName().equals(user.getEmail()))
                return new RegisterResponseModel(false, "Email or Username already exist!");
            arr.add(um.getUserId());
        }
        if (user.getUsername().length() < 3)
            return new RegisterResponseModel(false, "Username must have at least 3 characters!");
        if (user.getPassword().length() < 6)
            return new RegisterResponseModel(false, "Password must have at least 6 characters!");
        else if (!user.getPassword().matches(".*\\d.*"))
            return new RegisterResponseModel(false, "Password must contain at least 1 number!");

        while (arr.contains(x))
            x = r.nextInt(1000);

        ud.addUser(new RegisterRequestModel(x, user.getUsername(), user.getPassword(), user.getEmail(), false));
        return new RegisterResponseModel(true, "You have successfully registered!");
    }

//    @GetMapping("/my-fridge")
//    public List<FridgeFoodModel> getFridgeFood(@RequestParam(value = "id") int id) {
//        List<FridgeFoodModel> list = new ArrayList<>();
//    }
}
