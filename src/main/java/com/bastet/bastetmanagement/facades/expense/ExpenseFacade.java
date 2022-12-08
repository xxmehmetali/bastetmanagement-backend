package com.bastet.bastetmanagement.facades.expense;

import com.bastet.bastetmanagement.dtos.basedtos.ExpenseDto;

import java.util.UUID;

public interface ExpenseFacade {
    ExpenseDto findById(UUID id);
}
