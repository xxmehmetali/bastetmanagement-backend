package com.bastet.bastetmanagement.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Currencies")
@EntityListeners(AuditingEntityListener.class)
public class Currency {
    @Id
    @Column(name="id")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id = UUID.randomUUID();

    @Column(name = "currencyName ")
    private String currencyName;

    @Column(name = "currencySymbol")
    private String currencySymbol;

    @OneToMany(mappedBy = "salaryCurrency")
    private List<Employee> employeesPaid;

    @OneToMany(mappedBy = "expenseCurrencyType")
    private List<Expense> expenses;

    @Column(name = "createdAt")
    @JsonIgnore
    @CreatedDate
    private Date createdAt;

    @Column(name = "updatedAt")
    @JsonIgnore
    @LastModifiedDate
    private Date updatedAt;

    @PreRemove
    public void onDeleteSetNull(){
        employeesPaid.stream()
                .forEach(employee -> employee.setSalaryCurrency(null));

        expenses.stream()
                .forEach(expense -> expense.setExpenseCurrencyType(null));
    }
}
