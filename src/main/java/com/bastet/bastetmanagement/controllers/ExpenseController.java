package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.core.utilities.results.dataresults.SuccessDataResult;
import com.bastet.bastetmanagement.dtos.basedtos.ExpenseDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ExpenseSimplifiedDto;
import com.bastet.bastetmanagement.facades.expense.ExpenseFacade;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/expense")
@Log4j2
public class ExpenseController extends BaseController {
    @Resource
    private ExpenseFacade expenseFacade;

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id") UUID id) {
        return wrapSuccessDataResultWithMessage(expenseFacade.findById(id), "");
    }

    @GetMapping("/simplified/findById/{id}")
    public Result findByIdSimplified(@PathVariable("id") UUID id) {
        return wrapSuccessDataResultWithMessage(expenseFacade.findByIdSimplified(id), "");
    }

    @GetMapping("/findAll")
    public Result findAllPaged(Pageable pageable){
        return wrapSuccessDataResultWithMessage(expenseFacade.findAllPaged(pageable), "");
    }

    @GetMapping("/simplified/findAll")
    public Result findAllPagedSimplified(Pageable pageable){
        return wrapSuccessDataResultWithMessage(expenseFacade.findAllPagedSimplified(pageable), "");
    }
}
