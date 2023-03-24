package com.budgetapp.services;

import com.budgetapp.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<User, Long> {

   User findByUsername(String username);
}


