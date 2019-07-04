package com.dev.payments.model.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<CategoryDTO> getAll() {
        //return categoryService.getAll();
        return categoryMapper.toOut(categoryService.getAll());
    }


}
