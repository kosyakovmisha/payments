package com.dev.payments.category;

import com.dev.payments.payment.Payment;
import com.dev.payments.payment.PaymentDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoryDTO {

    private int id;
    private String name;
    private List<PaymentDTO> payments = new ArrayList<>();

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
