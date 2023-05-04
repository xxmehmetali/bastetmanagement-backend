package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.ExpenseTypeDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ExpenseTypeSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.ExpenseType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ExpenseTypeMapper {
    ExpenseTypeDto expenseTypeToExpenseTypeDto(ExpenseType expenseType);
    ExpenseType expenseTypeDtoToExpenseType(ExpenseTypeDto expenseTypeDto);
    ExpenseTypeSimplifiedDto expenseTypeToExpenseTypeSimplifiedDto(ExpenseType expenseType);
    ExpenseType expenseTypeSimplifiedDtoToExpenseType(ExpenseTypeSimplifiedDto expenseTypeSimplifiedDto);
    //list versions
    List<ExpenseType> expenseTypeDtoListToExpenseTypeList(List<ExpenseTypeDto> expenseTypeDtos);
    List<ExpenseTypeDto> expenseTypeListToExpenseTypeDtoList(List<ExpenseType> expenseTypes);

}
