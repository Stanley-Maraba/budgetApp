package com.budgetapp.controller;

import com.budgetapp.entities.User;
import com.budgetapp.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> getAllUsers()
    {
        return userService.findAllUsers();
    }

    @PostMapping("/saveUser")
    public void createUser(@RequestBody User user)
    {
            userService.saveUser(user);
    }

}
