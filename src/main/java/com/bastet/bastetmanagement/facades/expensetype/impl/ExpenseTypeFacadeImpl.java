package com.bastet.bastetmanagement.facades.expensetype.impl;


import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.ExpenseTypeDto;
import com.bastet.bastetmanagement.dtos.selectdtos.ExpenseSelectElementDto;
import com.bastet.bastetmanagement.dtos.selectdtos.ExpenseTypeSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ExpenseTypeSimplifiedDto;
import com.bastet.bastetmanagement.facades.expensetype.ExpenseTypeFacade;
import com.bastet.bastetmanagement.mappers.ExpenseTypeMapper;
import com.bastet.bastetmanagement.models.ExpenseType;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Expense;
import com.bastet.bastetmanagement.models.ExpenseType;
import com.bastet.bastetmanagement.services.expensetype.ExpenseTypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Component
public class ExpenseTypeFacadeImpl implements ExpenseTypeFacade {
    @Resource
    private ExpenseTypeService expenseTypeService;

    @Resource
    private ExpenseTypeMapper expenseTypeMapper;

    @Override
    public ExpenseTypeDto findById(UUID id) {
        return expenseTypeMapper.expenseTypeToExpenseTypeDto(expenseTypeService.findById(id));
    }

    @Override
    public ExpenseTypeSimplifiedDto findByIdSimplified(UUID id) {
        return expenseTypeMapper.expenseTypeToExpenseTypeSimplifiedDto(expenseTypeService.findById(id));
    }

    @Override
    public Page<ExpenseTypeDto> findAllPaged(Pageable pageable) {
        return expenseTypeService.findAllPaged(pageable).map(expenseType -> expenseTypeMapper.expenseTypeToExpenseTypeDto(expenseType));
    }

    @Override
    public Page<ExpenseTypeSimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return expenseTypeService.findAllPaged(pageable).map(expenseType -> expenseTypeMapper.expenseTypeToExpenseTypeSimplifiedDto(expenseType));
    }

    @Override
    public List<ExpenseTypeSelectElementDto> findAllForSelectElement(){
        List<ExpenseType> expenseTypes = expenseTypeService.findAll();
        return expenseTypeMapper.expenseTypeListToExpenseTypeSelectElementDtoList(expenseTypes);
    }

    @Override
    public boolean add(Dto dto) {
        ExpenseType expenseType = expenseTypeMapper.expenseTypeDtoToExpenseType((ExpenseTypeDto) dto);
        boolean success = expenseTypeService.add(expenseType);
        return success;
    }
    @Override
    public boolean deleteById(UUID id) {
        return expenseTypeService.deleteById(id);
    }
}
