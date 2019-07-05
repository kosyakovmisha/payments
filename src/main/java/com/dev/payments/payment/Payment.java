package com.dev.payments.payment;

import com.dev.payments.category.Category;
import com.dev.payments.client.Client;
import com.dev.payments.personalpayments.PersonalPayment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private BigDecimal cost;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name="category_id", nullable = false)
    private Category category;


    @OneToMany(
            mappedBy = "payment",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PersonalPayment> personalPayments = new ArrayList<>();

    protected Payment() {

    }

    public Payment(String name, String cost, Category category) {
        this.name = name;
        this.cost = new BigDecimal(cost);
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format(
                "Payment[id = %d, name = %s, cost = %f]",
                id, name, cost
        );
    }
}
