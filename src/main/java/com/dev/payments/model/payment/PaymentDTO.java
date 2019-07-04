package com.dev.payments.model.payment;

import com.dev.payments.model.category.Category;
import com.dev.payments.model.client.Client;
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
    private List<Client> clients = new ArrayList<>();

    @Override
    public String toString() {
        return String.format(
                "Payment[id = %d, name = %s, cost = %f]",
                id, name, cost
        );
    }
}
