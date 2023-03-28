package com.budgetapp.services;


import com.budgetapp.Repositories.UserRepository;
import com.budgetapp.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void saveUser(final User user) {
        userRepository.save(user);
    }

    public User findUserById(final Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    public void deleteUser(final Long id) {
        userRepository.deleteById(id);
    }
}
