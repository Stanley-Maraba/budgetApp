package com.budgetapp.entities;


import jakarta.persistence.Entity;

import jakarta.persistence.Table;

@Entity
@Table(name = "Category")
public class Category extends BaseEntity{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
