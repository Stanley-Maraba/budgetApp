package com.budgetapp.repositories;

import com.budgetapp.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExpensesRepository extends JpaRepository<Expense, Long> {
    Optional<List<Expense>> findByUserId(final Long user_id);
}
