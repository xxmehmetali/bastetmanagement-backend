package com.bastet.bastetmanagement.services.expense.impl;

import com.bastet.bastetmanagement.core.customexceptions.ModelNotFoundException;
import com.bastet.bastetmanagement.daos.ExpenseDao;
import com.bastet.bastetmanagement.models.Expense;
import com.bastet.bastetmanagement.services.expense.ExpenseService;

import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@Log4j2
public class ExpenseServiceImpl implements ExpenseService {
    @Resource
    private ExpenseDao expenseDao;


    @Override
    public Expense findById(UUID id) throws ModelNotFoundException {
        return expenseDao.findById(id).orElseThrow(() -> new ModelNotFoundException("Expense not found!"));
    }

    @Override
    public Page<Expense> findAllPaged(Pageable pageable) {
        return expenseDao.findAll(pageable);
    }

    @Override
    public List<Expense> findAll() {
        return expenseDao.findAll();
    }
}
