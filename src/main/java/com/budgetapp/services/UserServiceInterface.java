package com.budgetapp.services;

import com.budgetapp.entities.User;

import java.util.List;

public interface UserServiceInterface {

    List<User> findAllUsers();

    User FindByUsername(String username);

    void saveUser(User user);
}
