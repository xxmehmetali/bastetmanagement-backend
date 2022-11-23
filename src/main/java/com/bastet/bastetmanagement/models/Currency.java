package com.bastet.bastetmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Currency")
public class Currency {
    @Id
    @Column(name="id")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id = UUID.randomUUID();

    @Column(name = "currencyName ")
    private String currencyName ;

    @Column(name = "currencySymbol")
    private String currencySymbol ;

    @OneToMany(mappedBy = "expenseCurrencyType", fetch = FetchType.LAZY)
    private List<Expense> expenses;
}
