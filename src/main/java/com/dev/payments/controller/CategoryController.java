package com.dev.payments.controller;

import com.dev.payments.model.category.CategoryDTO;
import com.dev.payments.model.category.CategoryMapper;
import com.dev.payments.model.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private CategoryMapper categoryMapper;

    @GetMapping("/categories")
    public List<CategoryDTO> getAll() {
        return categoryMapper.toOut(categoryService.getAll());
    }

}
