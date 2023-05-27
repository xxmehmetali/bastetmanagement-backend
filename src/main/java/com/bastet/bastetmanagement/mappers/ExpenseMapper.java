package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.ExpenseDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CorporationSelectElementDto;
import com.bastet.bastetmanagement.dtos.selectdtos.ExpenseSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ExpenseSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Corporation;
import com.bastet.bastetmanagement.models.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                EmployeeMapper.class
        }
)
public interface ExpenseMapper {
    @Mappings({
            @Mapping(source = "spendedBy", target = "spendedBy", qualifiedByName = "employeeToEmployeeDto")
    })
    ExpenseDto expenseToExpenseDto(Expense expense);

    @Mapping(ignore = true, target = "id")
    @Mapping(source = "spendedBy", target = "spendedBy", qualifiedByName = "employeeDtoToEmployeeIdStatic")
    Expense expenseDtoToExpense(ExpenseDto expenseDto);

    @Named("expenseDtoToExpenseIdStatic")
    Expense expenseDtoToExpenseIdStatic(ExpenseDto expenseDto);

    ExpenseSimplifiedDto expenseToExpenseSimplifiedDto(Expense expense);
    Expense expenseSimplifiedDtoToExpense(ExpenseSimplifiedDto expenseSimplifiedDto);

    //list versions
    List<Expense> expenseDtoListToExpenseList(List<ExpenseDto> expenseDtos);
    List<ExpenseDto> expenseListToExpenseDtoList(List<Expense> expenses);

    List<ExpenseSelectElementDto> expenseListToExpenseSelectElementDtoList(List<Expense> expenses);
}
