package com.bastet.bastetmanagement.services.expensetype.impl;

import com.bastet.bastetmanagement.daos.ExpenseTypeDao;
import com.bastet.bastetmanagement.models.ExpenseType;
import com.bastet.bastetmanagement.services.expensetype.ExpenseTypeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
@Log4j2
public class ExpenseTypeServiceImpl implements ExpenseTypeService {
    @Resource
    private ExpenseTypeDao expenseTypeDao;
    @Override
    public ExpenseType findById(UUID id) {
        ExpenseType expenseType=expenseTypeDao.findById(id).orElse(null);
        return expenseType;
    }
}
