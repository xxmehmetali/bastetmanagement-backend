package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.core.utilities.results.dataresults.SuccessDataResult;
import com.bastet.bastetmanagement.dtos.basedtos.ExpenseDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ExpenseSimplifiedDto;
import com.bastet.bastetmanagement.facades.expense.ExpenseFacade;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessDataResult<ExpenseDto>(expenseFacade.findById(id), "data listed."));
    }

    @GetMapping("/simplified/findById/{id}")
    public ExpenseSimplifiedDto findByIdSimplified(@PathVariable("id") UUID id){
        return expenseFacade.findByIdSimplified(id);
    }
}
