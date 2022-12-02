package com.bastet.bastetmanagement.dtos.basedtos;

import lombok.*;

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
