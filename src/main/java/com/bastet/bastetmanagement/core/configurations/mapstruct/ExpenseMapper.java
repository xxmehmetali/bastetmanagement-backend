package com.bastet.bastetmanagement.core.configurations.mapstruct;

import com.bastet.bastetmanagement.dtos.basedtos.ExpenseDto;
import com.bastet.bastetmanagement.models.Expense;
import org.mapstruct.Mapper;

@Mapper
public interface ExpenseMapper {
    ExpenseDto expenseToExpenseDto(Expense expense);
    Expense expenseDtoToExpense(ExpenseDto expenseDto);
}
