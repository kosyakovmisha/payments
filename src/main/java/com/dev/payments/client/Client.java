package com.dev.payments.client;

import com.dev.payments.payment.Payment;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "client_payments",
        joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "payment_id", referencedColumnName = "id"))
    private List<Payment> payments = new ArrayList<>();

    protected Client() {

    }

    public Client(String firstName, String lastName, String balance, Payment... payments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = new BigDecimal(balance);
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
