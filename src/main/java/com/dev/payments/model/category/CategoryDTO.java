package com.dev.payments.model.category;

import com.dev.payments.model.Payment;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CategoryDTO {

    private long id;
    private String name;
    private Set<Payment> payments = new HashSet<>();

    protected CategoryDTO() {
    }

    public CategoryDTO(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
