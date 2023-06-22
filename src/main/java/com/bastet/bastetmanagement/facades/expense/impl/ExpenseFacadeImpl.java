package com.bastet.bastetmanagement.facades.expense.impl;


import com.bastet.bastetmanagement.core.utilities.results.baseresults.ErrorResult;
import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.DepartmentDto;
import com.bastet.bastetmanagement.dtos.basedtos.ExpenseDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CorporationSelectElementDto;
import com.bastet.bastetmanagement.dtos.selectdtos.ExpenseSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ExpenseSimplifiedDto;
import com.bastet.bastetmanagement.facades.expense.ExpenseFacade;
import com.bastet.bastetmanagement.mappers.ExpenseMapper;
import com.bastet.bastetmanagement.models.Corporation;
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
        return expenseMapper.expenseToExpenseDto(expenseService.findById(id));
    }

    @Override
    public ExpenseSimplifiedDto findByIdSimplified(UUID id) {
        return expenseMapper.expenseToExpenseSimplifiedDto(expenseService.findById(id));
    }

    @Override
    public Page<ExpenseDto> findAllPaged(Pageable pageable) {
        return expenseService.findAllPaged(pageable).map(expense -> expenseMapper.expenseToExpenseDto(expense));
    }

    @Override
    public Page<ExpenseSimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return expenseService.findAllPaged(pageable).map(expense -> expenseMapper.expenseToExpenseSimplifiedDto(expense));
    }

    @Override
    public List<ExpenseSelectElementDto> findAllForSelectElement(){
        List<Expense> expenses = expenseService.findAll();
        return expenseMapper.expenseListToExpenseSelectElementDtoList(expenses);
    }

    @Override
    public boolean add(Dto dto) {
        Expense expense = expenseMapper.expenseDtoToExpense((ExpenseDto) dto);
        boolean success = expenseService.add(expense);
        return success;
    }
    @Override
    public boolean deleteById(UUID id) {
        return expenseService.deleteById(id);
    }

    @Override
    public boolean update(Dto dto) {
        Expense expense = expenseMapper.expenseDtoToExpenseForUpdate((ExpenseDto) dto);
        boolean success = expenseService.add(expense);
        return success;
    }
}
