package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.ExpenseDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ExpenseSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Expense;
import org.mapstruct.Mapper;

import java.util.List;

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

    //list versions
    List<Expense> expenseDtoListToExpenseList(List<ExpenseDto> expenseDtos);
    List<ExpenseDto> expenseListToExpenseDtoList(List<Expense> expenses);
}
