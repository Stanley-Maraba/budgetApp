package com.budgetapp.services;

import com.budgetapp.entities.Category;
import com.budgetapp.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void deleteById(final Long id) {
        categoryRepository.deleteById(id);
    }

    public Category addCategory(final Category category) {
        return categoryRepository.save(category);
    }
}
