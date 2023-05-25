package com.budgetapp.services;

import com.budgetapp.entities.Expense;
import com.budgetapp.repositories.ExpensesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpensesService {

    private final ExpensesRepository expensesRepository;

    public ExpensesService(final ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }

    public List<Expense> findAllExpenses() {
        return expensesRepository.findAll();
    }

    public void deleteExpensesById(final Long id) {
        expensesRepository.deleteById(id);
    }

    public Expense addExpenses(final Expense expense) {
        return expensesRepository.save(expense);
    }

    public List<Expense> findExpensesByUserId(final Long userId) {
        return expensesRepository.findByUserId(userId);
    }
}
