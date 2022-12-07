package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.daos.ExpenseDao;
import com.bastet.bastetmanagement.models.Expense;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Resource
    private ExpenseDao expenseDao;

    @GetMapping("/findById/{id}")
    private Expense findById(@PathVariable("id")UUID id){
        return expenseDao.findById(id).orElse(null);
    }
}
