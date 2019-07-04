package com.dev.payments.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {

        return categoryRepository.findAll();
    }

    public Category getById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category getByName(String name) {
        return categoryRepository.findByName(name).orElse(null);
    }

    public Category createCategory(String name) {
        Category category = getByName(name);
        if (category == null) {
            category = new Category(name);
            categoryRepository.save(category);
        }
        return category;
    }


}
