package com.dev.payments.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

    @GetMapping("/categories")
    public List<Category> getAll() {
        return categoryService.getAll();
        //return categoryMapper.toOut(categoryService.getAll());
    }

    @GetMapping("/categories/{id}")
    public Category getById(@PathVariable int id) {
        Category category = categoryService.getById(id); //TODO: add exception
        return category;
    }

}
