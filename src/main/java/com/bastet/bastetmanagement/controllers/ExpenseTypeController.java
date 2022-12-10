package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.core.configurations.modelmapper.CustomModelMapper;
import com.bastet.bastetmanagement.daos.ExpenseTypeDao;
import com.bastet.bastetmanagement.dtos.basedtos.ExpenseTypeDto;
import com.bastet.bastetmanagement.models.ExpenseType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController

@RequestMapping("/expenseType")
public class ExpenseTypeController {

    @Resource
    private ExpenseTypeDao expenseTypeDao;

    @Resource
    private CustomModelMapper customModelMapper;
    @GetMapping("/findById/{id}")
    public ExpenseTypeDto findById(@PathVariable("id")UUID id){
        return customModelMapper.map(expenseTypeDao.findById(id).orElse(null), ExpenseTypeDto.class);
    }
}
