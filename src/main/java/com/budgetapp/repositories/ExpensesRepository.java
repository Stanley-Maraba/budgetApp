package com.budgetapp.repositories;

import com.budgetapp.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpensesRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUserId(final Long userId);
}
