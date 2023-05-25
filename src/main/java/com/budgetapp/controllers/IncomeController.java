package com.budgetapp.controllers;

import com.budgetapp.entities.Income;
import com.budgetapp.services.IncomeService;
import jakarta.persistence.EntityNotFoundException;
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
@RequestMapping(path = "/api/incomes")
public class IncomeController {

    private final IncomeService incomeService;

    public IncomeController(final IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @DeleteMapping(path = "/{id}")
    private ResponseEntity<Void> deleteIncome(@PathVariable final Long id) {
        incomeService.deleteIncome(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<Income> addIncome(@RequestBody final Income income) {
        final var createIncome = incomeService.addIncome(income);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createIncome);
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<List<Income>> findAllIncomes() {
        final var findIncomes = incomeService.findAllIncomes();
        return ResponseEntity.ok(findIncomes);
    }

    @GetMapping(path = "/{user_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<Income>> findIncomesById(@PathVariable final Long user_id) {
        try {
            List<Income> income = incomeService.findIncomesByUserId(user_id);
            return ResponseEntity.ok(income);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
