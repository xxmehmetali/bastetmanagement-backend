package com.bastet.bastetmanagement.core.configurations.mapstruct;

import com.bastet.bastetmanagement.dtos.basedtos.ExpenseTypeDto;
import com.bastet.bastetmanagement.models.ExpenseType;
import org.mapstruct.Mapper;

@Mapper
public interface ExpenseTypeMapper {
    ExpenseTypeDto expenseTypeToExpenseTypeDto(ExpenseType expenseType);
    ExpenseType expenseTypeDtoToExpenseType(ExpenseTypeDto expenseTypeDto);
}
