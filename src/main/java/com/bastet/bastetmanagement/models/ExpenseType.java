package com.bastet.bastetmanagement.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ExpenseTypes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ExpenseType {
    @Id
    @Column(name="id")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "expenseType")
    @JsonIgnore
    private List<Expense> expenses;

    @Column(name = "createdAt")
    @CreatedDate
    private Date createdAt;

    @Column(name = "updatedAt")
    @LastModifiedDate
    private Date updatedAt;

    @PreRemove
    public void onDeleteSetNull(){
        expenses.stream()
                .forEach(expense -> expense.setExpenseCurrencyType(null));
    }

}
