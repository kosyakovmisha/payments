package com.dev.payments.payment;

import com.dev.payments.category.Category;
import com.dev.payments.client.Client;
import com.dev.payments.client.ClientDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PaymentDTO {

    private int id;
    private String name;
    private BigDecimal cost;
    private Category category;

    @Override
    public String toString() {
        return String.format(
                "Payment[id = %d, name = %s, cost = %f]",
                id, name, cost
        );
    }
}
