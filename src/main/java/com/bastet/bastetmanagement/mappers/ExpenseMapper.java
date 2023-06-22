package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.ExpenseDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CorporationSelectElementDto;
import com.bastet.bastetmanagement.dtos.selectdtos.ExpenseSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ExpenseSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Corporation;
import com.bastet.bastetmanagement.models.Expense;
import com.bastet.bastetmanagement.models.ExpenseType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                EmployeeMapper.class,
                CurrencyMapper.class,
                SocialActivityMapper.class,
                ExpenseTypeMapper.class
        }
)
public interface ExpenseMapper {
    @Mappings({
            @Mapping(source = "spendedBy", target = "spendedBy", qualifiedByName = "employeeToEmployeeDto")
    })
    ExpenseDto expenseToExpenseDto(Expense expense);

    @Mapping(ignore = true, target = "id")
    @Mappings({
            @Mapping(source = "spendedBy", target = "spendedBy", qualifiedByName = "employeeDtoToEmployeeOnlyId"),
            @Mapping(source = "expenseCurrencyType", target = "expenseCurrencyType", qualifiedByName = "currencyDtoToCurrencyOnlyId"),
            @Mapping(source = "socialActivity", target = "socialActivity", qualifiedByName = "socialActivityDtoToSocialActivityOnlyId")
    })
    Expense expenseDtoToExpense(ExpenseDto expenseDto);

    @Mappings({
            @Mapping(source = "spendedBy", target = "spendedBy", qualifiedByName = "employeeDtoToEmployeeOnlyId"),
            @Mapping(source = "expenseCurrencyType", target = "expenseCurrencyType", qualifiedByName = "currencyDtoToCurrencyOnlyId"),
            @Mapping(source = "socialActivity", target = "socialActivity", qualifiedByName = "socialActivityDtoToSocialActivityOnlyId"),
            @Mapping(source = "expenseType", target = "expenseType", qualifiedByName = "expenseTypeDtoToExpenseTypeOnlyId")
    })
    Expense expenseDtoToExpenseForUpdate(ExpenseDto expenseDto);

    @Named("expenseDtoToExpenseIdStatic")
    Expense expenseDtoToExpenseIdStatic(ExpenseDto expenseDto);

    @Named("expenseDtoToExpenseOnlyId")
    default Expense expenseDtoToExpenseOnlyId(ExpenseDto expenseDto){
        Expense expense = new Expense();
        expense.setId( expenseDto.getId() );
        return expense;
    }

    ExpenseSimplifiedDto expenseToExpenseSimplifiedDto(Expense expense);
    Expense expenseSimplifiedDtoToExpense(ExpenseSimplifiedDto expenseSimplifiedDto);


    List<ExpenseDto> expenseListToExpenseDtoList(List<Expense> expenses);

    List<ExpenseSelectElementDto> expenseListToExpenseSelectElementDtoList(List<Expense> expenses);
}
