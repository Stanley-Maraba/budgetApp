package com.budgetapp.services;

import com.budgetapp.entities.User;
import com.budgetapp.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(final User user) {
        return userRepository.save(user);
    }

    public User findUserById(final Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("user with id : " + id + " is not found"));
        return user;
    }

    public void deleteUser(final Long id) {
        userRepository.deleteById(id);
    }
}
