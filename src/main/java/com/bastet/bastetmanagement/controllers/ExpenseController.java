package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.core.utilities.results.dataresults.SuccessDataResult;
import com.bastet.bastetmanagement.daos.ExpenseDao;
import com.bastet.bastetmanagement.dtos.basedtos.ExpenseDto;
import com.bastet.bastetmanagement.facades.expense.ExpenseFacade;
import com.bastet.bastetmanagement.models.Expense;
import com.bastet.bastetmanagement.services.expense.impl.ExpenseServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/expense")
@Log4j2
public class ExpenseController {
    @Resource
    private ExpenseFacade expenseFacade;

    @GetMapping("/findById/{id}")
    public ResponseEntity findById(@PathVariable("id")UUID id){
//        return expenseFacade.findById(id);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SuccessDataResult<ExpenseDto>(expenseFacade.findById(id), "data listed."));
    }
}
