package com.bastet.bastetmanagement.facades.expense;

import com.bastet.bastetmanagement.dtos.basedtos.ExpenseDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ExpenseSimplifiedDto;

import java.util.UUID;

public interface ExpenseFacade {
    ExpenseDto findById(UUID id);
    ExpenseSimplifiedDto findByIdSimplified(UUID id);
}
