package com.bastet.bastetmanagement.facades.expense.impl;

import com.bastet.bastetmanagement.core.configurations.modelmapper.CustomModelMapper;
import com.bastet.bastetmanagement.core.utilities.results.baseresults.ErrorResult;
import com.bastet.bastetmanagement.dtos.basedtos.ExpenseDto;
import com.bastet.bastetmanagement.facades.expense.ExpenseFacade;
import com.bastet.bastetmanagement.models.Expense;
import com.bastet.bastetmanagement.services.expense.ExpenseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component
@Log4j2
public class ExpenseFacadeImpl implements ExpenseFacade {
    @Resource
    private ExpenseService expenseService;

    @Resource
    private CustomModelMapper customModelMapper;

    public ExpenseDto findById(UUID id) {
        Expense expense = expenseService.findById(id);
        ExpenseDto expenseDto = customModelMapper.map(expense, ExpenseDto.class);
        return expenseDto;
    }
}
