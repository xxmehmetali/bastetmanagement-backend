package com.bastet.bastetmanagement.facades.expensetype;

import com.bastet.bastetmanagement.dtos.basedtos.ExpenseTypeDto;

import java.util.UUID;

public interface ExpenseTypeFacade {
    ExpenseTypeDto findById(UUID id);
}
