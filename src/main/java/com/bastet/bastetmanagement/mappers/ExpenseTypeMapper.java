package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.ExpenseTypeDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CorporationSelectElementDto;
import com.bastet.bastetmanagement.dtos.selectdtos.ExpenseTypeSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ExpenseTypeSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Corporation;
import com.bastet.bastetmanagement.models.ExpenseType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface ExpenseTypeMapper {
    ExpenseTypeDto expenseTypeToExpenseTypeDto(ExpenseType expenseType);

    @Mapping(ignore = true, target = "id")
    ExpenseType expenseTypeDtoToExpenseType(ExpenseTypeDto expenseTypeDto);

    @Named("expenseTypeDtoToExpenseTypeIdStatic")
    ExpenseType expenseTypeDtoToExpenseTypeIdStatic(ExpenseTypeDto expenseTypeDto);

    ExpenseTypeSimplifiedDto expenseTypeToExpenseTypeSimplifiedDto(ExpenseType expenseType);
    ExpenseType expenseTypeSimplifiedDtoToExpenseType(ExpenseTypeSimplifiedDto expenseTypeSimplifiedDto);
    //list versions
    List<ExpenseType> expenseTypeDtoListToExpenseTypeList(List<ExpenseTypeDto> expenseTypeDtos);
    List<ExpenseTypeDto> expenseTypeListToExpenseTypeDtoList(List<ExpenseType> expenseTypes);
    List<ExpenseTypeSelectElementDto> expenseTypeListToExpenseTypeSelectElementDtoList(List<ExpenseType> expenseTypes);

}
