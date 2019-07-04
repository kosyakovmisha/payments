package com.dev.payments.model.payment;

import com.dev.payments.model.category.Category;
import com.dev.payments.model.client.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data

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

    @ManyToMany(fetch = FetchType.LAZY,
            mappedBy = "payments")
    private List<Client> clients = new ArrayList<>();

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
