package com.bastet.bastetmanagement.models;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.util.UUID;

public class Expense {
    @Id
    @Column(name="id")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "spendedBy")
    private String spendedBy;

    @Column(name = "expenseAmount")
    private Double expenseAmount;

    @JoinColumn(name = "expenseCurrencyType")
    @ManyToOne
    private Currency expenseCurrencyType;

    @Column(name = "vaucherNo")
    private Double vaucherNo;

    @Column(name = "expenseType")
    private String expenseType;

    @Column(name = "spentDateTime")
    private String spentDateTime;
}
