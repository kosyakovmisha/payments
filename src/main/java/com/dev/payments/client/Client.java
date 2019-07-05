package com.dev.payments.client;

import com.dev.payments.personalpayments.PersonalPayment;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull
    private String firstName;

    @Column
    @NotNull
    private String lastName;

    @Column
    private BigDecimal balance;

    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PersonalPayment> personalPayments = new ArrayList<>();

    protected Client() {

    }

    public Client(String firstName, String lastName, String balance, PersonalPayment... payments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = new BigDecimal(balance);
        this.personalPayments = Stream.of(payments).collect(Collectors.toList());
        this.personalPayments.forEach(payment -> {
            payment.setClient(this);
            payment.setId(this.id);
        });
    }

    @Override
    public String toString() {
        return String.format(
                "Client[id = %d, firstName = %s, lastName = %s, balance = %f]",
                id, firstName, lastName, balance
        );
    }
}
