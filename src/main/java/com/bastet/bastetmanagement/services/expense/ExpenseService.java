package com.bastet.bastetmanagement.services.expense;

import com.bastet.bastetmanagement.core.customexceptions.ModelNotFoundException;
import com.bastet.bastetmanagement.models.Expense;

import java.util.UUID;

public interface ExpenseService {
    Expense findById(UUID id) throws ModelNotFoundException;
}
