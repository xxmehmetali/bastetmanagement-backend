package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ExpenseDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ExpenseSimplifiedDto;
import com.bastet.bastetmanagement.models.Expense;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses = {
                EmployeeMapper.class
        }
)
public interface ExpenseMapper {
    ExpenseDto expenseToExpenseDto(Expense expense);
    Expense expenseDtoToExpense(ExpenseDto expenseDto);
    ExpenseSimplifiedDto expenseToExpenseSimplifiedDto(Expense expense);
    Expense expenseSimplifiedDtoToExpense(ExpenseSimplifiedDto expenseSimplifiedDto);
}
