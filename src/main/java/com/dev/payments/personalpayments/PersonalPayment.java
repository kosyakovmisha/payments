package com.dev.payments.personalpayments;


import com.dev.payments.client.Client;
import com.dev.payments.payment.Payment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class PersonalPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private boolean isPaid;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name="payment_id", nullable = false)
    private Payment payment;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name="client_id", nullable = false)
    private Client client;

    protected PersonalPayment() {

    }

    public PersonalPayment(Payment payment) {
        this.isPaid = false;
        this.payment = payment;
    }
}
