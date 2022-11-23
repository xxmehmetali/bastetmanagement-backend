package com.bastet.bastetmanagement.models;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Expenses")
public class Expense {
    @Id
    @Column(name="id")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "spendedBy")
    private Employee spendedBy;

    @Column(name = "expenseAmount")
    private Double expenseAmount;

    @ManyToOne(fetch = FetchType.LAZY, cascade= CascadeType.ALL)
    @JoinColumn(name = "expenseCurrencyType")
    private Currency expenseCurrencyType;

    @Column(name = "vaucherNo")
    private Double vaucherNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expenseType")
    private ExpenseType expenseType;

    @Column(name = "spentDateTime")
    private String spentDateTime;

}
