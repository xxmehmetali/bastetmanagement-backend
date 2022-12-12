package com.bastet.bastetmanagement.dtos.simplifieddtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseSimplifiedDto {
    private UUID id;

    private String name;

    private String description;

    private Double vaucherNo;

    private ExpenseTypeSimplifiedDto expenseType;

    private String spentDateTime;

}
