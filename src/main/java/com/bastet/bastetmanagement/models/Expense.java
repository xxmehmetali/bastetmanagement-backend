package com.bastet.bastetmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

import java.util.UUID;

@Data
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
