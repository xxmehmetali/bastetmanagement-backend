package com.bastet.bastetmanagement.facades.expense;

import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.ExpenseDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ExpenseSimplifiedDto;
import com.bastet.bastetmanagement.facades.GenericFacade;

import java.util.UUID;

public interface ExpenseFacade extends GenericFacade<Dto> {
    ExpenseDto findById(UUID id);
    ExpenseSimplifiedDto findByIdSimplified(UUID id);
}
