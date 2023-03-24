package com.budgetapp.services;


import com.budgetapp.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;
    private final UserCrudRepository userCrudRepository;

    public UserService(UserRepository userRepository, UserCrudRepository userCrudRepository) {
        this.userRepository = userRepository;
        this.userCrudRepository = userCrudRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User FindByUsername(String username)
    {
        return userCrudRepository.findByUsername(username);
    }

    @Override
    public void saveUser(User user)
    {
        userCrudRepository.save(user);
    }


}
