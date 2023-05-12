package com.bastet.bastetmanagement.services.expensetype.impl;

import com.bastet.bastetmanagement.core.customexceptions.ModelNotFoundException;
import com.bastet.bastetmanagement.core.utilities.results.ResultUtil;
import com.bastet.bastetmanagement.daos.ExpenseTypeDao;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.ExpenseType;
import com.bastet.bastetmanagement.services.expensetype.ExpenseTypeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
public class ExpenseTypeServiceImpl implements ExpenseTypeService {
    @Resource
    private ExpenseTypeDao expenseTypeDao;

    @Override
    public ExpenseType findById(UUID id) {
        return expenseTypeDao.findById(id).orElseThrow(() -> new ModelNotFoundException("ExpenseType not found."));
    }

    @Override
    public Page<ExpenseType> findAllPaged(Pageable pageable) {
        return expenseTypeDao.findAll(pageable);
    }

    @Override
    public List<ExpenseType> findAll() {
        return expenseTypeDao.findAll();
    }

    @Override
    public boolean add(ExpenseType expenseType) {
        return ResultUtil.extractSuccess(expenseTypeDao.save(expenseType));
    }
}
