package com.budgetapp.controllers;

import com.budgetapp.entities.Expense;
import com.budgetapp.services.ExpensesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/expenses")
public class ExpensesController {

    private final ExpensesService expensesService;

    public ExpensesController(final ExpensesService expensesService) {
        this.expensesService = expensesService;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable final Long id) {
        expensesService.deleteExpensesById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Expense>> findExpenses() {
        final var findExpenses = expensesService.findAllExpenses();
        return ResponseEntity.ok(findExpenses);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Expense> saveExpenses(@RequestBody final Expense expense) {
        final var createExpenses = expensesService.addExpenses(expense);
        return ResponseEntity.status(HttpStatus.CREATED).body(createExpenses);
    }

    @GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<Expense>> findIncomesById(@PathVariable final Long userId) {
        List<Expense> expense = expensesService.findExpensesByUserId(userId);
        return ResponseEntity.ok(expense);
    }
}
