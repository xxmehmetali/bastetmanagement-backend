package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ExpenseTypeDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ExpenseTypeSimplifiedDto;
import com.bastet.bastetmanagement.models.ExpenseType;
import org.mapstruct.Mapper;

@Mapper
public interface ExpenseTypeMapper {
    ExpenseTypeDto expenseTypeToExpenseTypeDto(ExpenseType expenseType);
    ExpenseType expenseTypeDtoToExpenseType(ExpenseTypeDto expenseTypeDto);
    ExpenseTypeSimplifiedDto expenseTypeToExpenseTypeSimplifiedDto(ExpenseType expenseType);
    ExpenseType expenseTypeSimplifiedDtoToExpenseType(ExpenseTypeSimplifiedDto expenseTypeSimplifiedDto);
}
