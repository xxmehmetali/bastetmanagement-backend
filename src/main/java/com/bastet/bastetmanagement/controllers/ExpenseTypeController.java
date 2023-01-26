package com.bastet.bastetmanagement.controllers;


import com.bastet.bastetmanagement.daos.ExpenseTypeDao;
import com.bastet.bastetmanagement.dtos.basedtos.ExpenseTypeDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ExpenseTypeSimplifiedDto;
import com.bastet.bastetmanagement.facades.expensetype.ExpenseTypeFacade;
import com.bastet.bastetmanagement.models.ExpenseType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController

@RequestMapping("/api/v1/expenseType")
public class ExpenseTypeController extends BaseController {

    @Resource
    private ExpenseTypeDao expenseTypeDao;
    @Resource
    private ExpenseTypeFacade expenseTypeFacade;

    @GetMapping("/findById/{id}")
    public ExpenseTypeDto findById(@PathVariable("id")UUID id){
        return null;
    }

    @GetMapping("/simplified/findById/{id}")
    public ExpenseTypeSimplifiedDto findByIdSimplified(@PathVariable("id") UUID id){
        return expenseTypeFacade.findByIdSimplified(id);
    }
}
