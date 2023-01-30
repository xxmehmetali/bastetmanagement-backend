package com.bastet.bastetmanagement.facades.expense.impl;


import com.bastet.bastetmanagement.core.utilities.results.baseresults.ErrorResult;
import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.DepartmentDto;
import com.bastet.bastetmanagement.dtos.basedtos.ExpenseDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ExpenseSimplifiedDto;
import com.bastet.bastetmanagement.facades.expense.ExpenseFacade;
import com.bastet.bastetmanagement.mappers.ExpenseMapper;
import com.bastet.bastetmanagement.models.Expense;
import com.bastet.bastetmanagement.services.expense.ExpenseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Component
@Log4j2
public class ExpenseFacadeImpl implements ExpenseFacade {
    @Resource
    private ExpenseService expenseService;

    @Resource
    private ExpenseMapper expenseMapper;

    @Override
    public ExpenseDto findById(UUID id) {
        return null;
    }

    @Override
    public ExpenseSimplifiedDto findByIdSimplified(UUID id) {
        return null;
    }

    @Override
    public Page<ExpenseDto> findAllPaged(Pageable pageable) {
        Page pageImpl = expenseService.findAllPaged(pageable);
        List<ExpenseDto> dtos = expenseMapper.expenseListToExpenseDtoList(pageImpl.getContent());
        return new PageImpl<>(dtos, pageable, pageImpl.getTotalPages());

    }

    @Override
    public Page<ExpenseSimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return null;
    }
}
