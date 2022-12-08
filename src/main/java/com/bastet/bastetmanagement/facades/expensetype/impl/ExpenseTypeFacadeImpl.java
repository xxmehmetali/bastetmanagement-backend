package com.bastet.bastetmanagement.facades.expensetype.impl;

import com.bastet.bastetmanagement.dtos.basedtos.ExpenseTypeDto;
import com.bastet.bastetmanagement.facades.expensetype.ExpenseTypeFacade;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ExpenseTypeFacadeImpl implements ExpenseTypeFacade {
    @Override
    public ExpenseTypeDto findById(UUID id) {
        return null;
    }
}
