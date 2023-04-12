package com.budgetapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "category")
    private List<Expense> expenses;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
