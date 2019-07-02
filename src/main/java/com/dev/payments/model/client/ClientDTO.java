package com.dev.payments.model.client;

import com.dev.payments.model.payment.Payment;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ClientDTO {

    private long id;
    private String firstName;
    private String lastName;
    private BigDecimal balance;
    private List<Payment> payments = new ArrayList<>();

    @Override
    public String toString() {
        return String.format(
                "Client[id = %d, firstName = %s, lastName = %s, balance = %f]",
                id, firstName, lastName, balance
        );
    }
}
