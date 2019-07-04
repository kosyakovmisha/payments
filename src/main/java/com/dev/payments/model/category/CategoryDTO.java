package com.dev.payments.model.category;

import com.dev.payments.model.payment.Payment;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoryDTO {

    private int id;
    private String name;
    private List<Payment> payments = new ArrayList<>();

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
