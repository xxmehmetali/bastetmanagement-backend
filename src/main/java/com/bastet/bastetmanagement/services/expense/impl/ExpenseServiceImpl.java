package com.bastet.bastetmanagement.services.expense.impl;

import com.bastet.bastetmanagement.core.customexceptions.ModelNotFoundException;
import com.bastet.bastetmanagement.daos.ExpenseDao;
import com.bastet.bastetmanagement.models.Expense;
import com.bastet.bastetmanagement.services.expense.ExpenseService;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.UUID;

@Service
@Log4j2
public class ExpenseServiceImpl implements ExpenseService {
    @Resource
    private ExpenseDao expenseDao;


    @Override
    public Expense findById(UUID id) throws ModelNotFoundException {
        Expense expense = expenseDao.findById(id).orElseThrow(() -> new ModelNotFoundException("Expense not found!"));
        return expense;
    }

}
