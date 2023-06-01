package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.core.constants.ResultConstants;
import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.core.utilities.results.dataresults.SuccessDataResult;
import com.bastet.bastetmanagement.dtos.basedtos.EmployeeDto;
import com.bastet.bastetmanagement.dtos.basedtos.ExpenseDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CorporationSelectElementDto;
import com.bastet.bastetmanagement.dtos.selectdtos.ExpenseSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ExpenseSimplifiedDto;
import com.bastet.bastetmanagement.facades.expense.ExpenseFacade;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Branch;
import com.bastet.bastetmanagement.models.Expense;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/expense")
@Log4j2
public class ExpenseController extends BaseController {
    @Resource
    private ExpenseFacade expenseFacade;

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id") UUID id) {
        return wrapSuccessDataResultWithMessage(expenseFacade.findById(id), ResultConstants.foundMessage(Expense.class));
    }

    @GetMapping("/simplified/findById/{id}")
    public Result findByIdSimplified(@PathVariable("id") UUID id) {
        return wrapSuccessDataResultWithMessage(expenseFacade.findByIdSimplified(id), ResultConstants.foundMessage(Expense.class));
    }

    @GetMapping("/findAll")
    public Result findAllPaged(Pageable pageable){
        return wrapSuccessDataResultWithMessage(expenseFacade.findAllPaged(pageable), ResultConstants.dataListedMessage(Expense.class));
    }

    @GetMapping("/simplified/findAll")
    public Result findAllPagedSimplified(Pageable pageable){
        return wrapSuccessDataResultWithMessage(expenseFacade.findAllPagedSimplified(pageable), ResultConstants.dataListedMessage(Expense.class));
    }

    @PostMapping(value = "/add",consumes = "application/json")
    public Result add(@RequestBody ExpenseDto expenseDto){
        boolean success = expenseFacade.add(expenseDto);
        return wrapResultWithMessage(success, ResultConstants.addedMessage(Expense.class));
    }
    @GetMapping(value = "/selectElement/findAll")
    public Result findAllForSelectElement() {
        List<ExpenseSelectElementDto> expenseSelectElementDtos = (List<ExpenseSelectElementDto>) expenseFacade.findAllForSelectElement();
        return wrapSuccessDataResultWithMessage(expenseSelectElementDtos, ResultConstants.dataListedMessageForSelection(Expense.class));
    }
    @DeleteMapping("/deleteById")
    public Result deleteById(@RequestParam("id")  UUID id) {
        boolean success = expenseFacade.deleteById(id);
        return wrapResultWithMessage(success, ResultConstants.deletedMessage(Expense.class));
    }
}
