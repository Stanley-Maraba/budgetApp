package com.budgetapp.repositories;

import com.budgetapp.entities.Income;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncomeRepository extends JpaRepository<Income, Long> {
    List<Income> findByUserId(final Long userId);
}
