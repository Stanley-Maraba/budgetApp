package com.budgetapp.services;

import com.budgetapp.entities.Income;
import com.budgetapp.repositories.IncomeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeService {

    private final IncomeRepository incomeRepository;

    public IncomeService(final IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public Income addIncome(final Income income) {
        return incomeRepository.save(income);
    }

    public void deleteIncome(final Long id) {
        incomeRepository.deleteById(id);
    }

    public List<Income> findAllIncomes() {
        return incomeRepository.findAll();
    }

    public List<Income> findIncomesByUserId(final Long user_id) {
        return incomeRepository.findByUserId(user_id).orElseThrow(EntityNotFoundException::new);
    }
}
