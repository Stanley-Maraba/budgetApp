package com.budgetapp.repositories;

import com.budgetapp.entities.Income;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IncomeRepository extends JpaRepository<Income, Long> {
    Optional<List<Income>> findByUserId(final Long userId);
}
