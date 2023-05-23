package com.bastet.bastetmanagement.dtos.basedtos;

import com.bastet.bastetmanagement.dtos.Dto;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDto extends Dto {
    private UUID id;

    private String name;

    private String description;

    private EmployeeDto spendedBy;

    private String voucherNo;

    private ExpenseTypeDto expenseType;

    private Double expenseAmount;

    private Date spentDateTime;


}
