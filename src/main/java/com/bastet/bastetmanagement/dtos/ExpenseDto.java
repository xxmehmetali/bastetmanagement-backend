package com.bastet.bastetmanagement.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
public class ExpenseDto {
    private UUID id;

    private String name;

    private String description;

    private EmployeeDto spendedBy;

    private Double vaucherNo;

    private ExpenseTypeDto expenseType;

    private String spentDateTime;


}
