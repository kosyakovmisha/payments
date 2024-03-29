package com.dev.payments.client;

import com.dev.payments.payment.Payment;
import com.dev.payments.payment.PaymentDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ClientDTO {

    private int id;
    private String firstName;
    private String lastName;
    private BigDecimal balance;
    private List<PaymentDTO> payments = new ArrayList<>();

    @Override
    public String toString() {
        return String.format(
                "Client[id = %d, firstName = %s, lastName = %s, balance = %f]",
                id, firstName, lastName, balance
        );
    }
}
