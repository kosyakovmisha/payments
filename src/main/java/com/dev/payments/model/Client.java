package com.dev.payments.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @NotNull
    private String firstName;

    @Column
    @NotNull
    private String lastName;
    private BigDecimal balance;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "client_payments",
        joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "payment_id", referencedColumnName = "id"))
    private List<Payment> payments;

    protected Client() {

    }

    public Client(String firstName, String lastName, BigDecimal balance, Payment... payments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.payments = Stream.of(payments).collect(Collectors.toList());
        this.payments.forEach(payment -> payment.getClients().add(this));
    }

    @Override
    public String toString() {
        return String.format(
                "Client[id = %d, firstName = %s, lastName = %s, balance = %f]",
                id, firstName, lastName, balance
        );
    }
}
