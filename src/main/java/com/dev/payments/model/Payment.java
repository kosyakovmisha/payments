package com.dev.payments.model;

import com.dev.payments.model.category.Category;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private BigDecimal cost;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name="category_id", nullable = false)
    private Category category;

    @ManyToMany(mappedBy = "payments")
    private Set<Client> clients = new HashSet<>();

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
