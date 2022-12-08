package com.bastet.bastetmanagement.services.expensetype;

import com.bastet.bastetmanagement.models.ExpenseType;

import java.util.UUID;

public interface ExpenseTypeService {
    ExpenseType findById(UUID id);
}
