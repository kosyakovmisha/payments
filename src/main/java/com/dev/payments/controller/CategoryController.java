package com.dev.payments.controller;

import com.dev.payments.model.category.Category;
import com.dev.payments.model.category.CategoryDTO;
import com.dev.payments.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/categories")
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> convertToDTO(category))
                .collect(Collectors.toList());
    }

    private CategoryDTO convertToDTO(Category category) {
        modelMapper.validate();
        return modelMapper.map(category, CategoryDTO.class);
    }
}
