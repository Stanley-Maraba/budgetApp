package com.budgetapp.Repositories;

import com.budgetapp.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpensesRepository extends JpaRepository<Expense, Long> {

}
