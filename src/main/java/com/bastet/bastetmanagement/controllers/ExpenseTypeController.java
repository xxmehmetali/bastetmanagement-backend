package com.bastet.bastetmanagement.controllers;


import com.bastet.bastetmanagement.core.constants.ResultConstants;
import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.dtos.basedtos.EmployeeDto;
import com.bastet.bastetmanagement.dtos.basedtos.ExpenseTypeDto;
import com.bastet.bastetmanagement.dtos.selectdtos.ExpenseTypeSelectElementDto;
import com.bastet.bastetmanagement.facades.expensetype.ExpenseTypeFacade;
import com.bastet.bastetmanagement.models.Employee;
import com.bastet.bastetmanagement.models.Expense;
import com.bastet.bastetmanagement.models.ExpenseType;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/expenseType")
public class ExpenseTypeController extends BaseController {
    @Resource
    private ExpenseTypeFacade expenseTypeFacade;

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id") UUID id) {
        return wrapSuccessDataResultWithMessage(expenseTypeFacade.findById(id), ResultConstants.foundMessage(ExpenseType.class));
    }

    @GetMapping("/simplified/findById/{id}")
    public Result findByIdSimplified(@PathVariable("id") UUID id) {
        return wrapSuccessDataResultWithMessage(expenseTypeFacade.findByIdSimplified(id), ResultConstants.foundMessage(ExpenseType.class));
    }

    @GetMapping("/findAll")
    public Result findAllPaged(Pageable pageable) {
        return wrapSuccessDataResultWithMessage(expenseTypeFacade.findAllPaged(pageable), ResultConstants.dataListedMessage(ExpenseType.class));
    }

    @GetMapping("/simplified/findAll")
    public Result findAllPagedSimplified(Pageable pageable) {
        return wrapSuccessDataResultWithMessage(expenseTypeFacade.findAllPagedSimplified(pageable), ResultConstants.dataListedMessage(ExpenseType.class));
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public Result add(@RequestBody ExpenseTypeDto expenseTypeDto) {
        boolean success = expenseTypeFacade.add(expenseTypeDto);
        return wrapResultWithMessage(success, ResultConstants.addedMessage(Expense.class));
    }

    @GetMapping(value = "/selectElement/findAll")
    public Result findAllForSelectElement() {
        List<ExpenseTypeSelectElementDto> expenseSelectElementDtos = (List<ExpenseTypeSelectElementDto>) expenseTypeFacade.findAllForSelectElement();
        return wrapSuccessDataResultWithMessage(expenseSelectElementDtos, ResultConstants.dataListedMessageForSelection(ExpenseType.class));
    }

    @DeleteMapping("/deleteById")
    public Result deleteById(@RequestParam("id") UUID id) {
        boolean success = expenseTypeFacade.deleteById(id);
        return wrapResultWithMessage(success, ResultConstants.deletedMessage(ExpenseType.class));
    }

    @PostMapping(value = "/update", consumes = "application/json")
    public Result update(@RequestBody ExpenseTypeDto expenseTypeDto) {
        boolean success = expenseTypeFacade.update(expenseTypeDto);
        return wrapResultWithMessage(success, ResultConstants.updatedMessage(ExpenseType.class));
    }

}
