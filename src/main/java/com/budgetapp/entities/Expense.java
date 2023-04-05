package com.budgetapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "expenses")
public class Expense extends BaseEntity {

    private String name;
    private BigDecimal value;

    @ManyToOne
    private User user;

    @ManyToOne
    private Category category;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(final BigDecimal value) {
        this.value = value;
    }
}
