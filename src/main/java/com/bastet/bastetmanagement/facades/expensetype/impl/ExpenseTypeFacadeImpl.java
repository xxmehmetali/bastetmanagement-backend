package com.bastet.bastetmanagement.facades.expensetype.impl;


import com.bastet.bastetmanagement.dtos.basedtos.ExpenseTypeDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ExpenseTypeSimplifiedDto;
import com.bastet.bastetmanagement.facades.expensetype.ExpenseTypeFacade;
import com.bastet.bastetmanagement.services.expensetype.ExpenseTypeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component
public class ExpenseTypeFacadeImpl implements ExpenseTypeFacade {
    @Resource
    private ExpenseTypeService expenseTypeService;

    @Override
    public ExpenseTypeDto findById(UUID id) {
        return null;
    }



    @Override
    public ExpenseTypeSimplifiedDto findByIdSimplified(UUID id) {
        return null;
    }
}
