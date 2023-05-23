package com.bastet.bastetmanagement.controllers;


import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.daos.ExpenseTypeDao;
import com.bastet.bastetmanagement.dtos.basedtos.ExpenseDto;
import com.bastet.bastetmanagement.dtos.basedtos.ExpenseTypeDto;
import com.bastet.bastetmanagement.dtos.selectdtos.ExpenseTypeSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ExpenseTypeSimplifiedDto;
import com.bastet.bastetmanagement.facades.expensetype.ExpenseTypeFacade;
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
    public Result findById(@PathVariable("id")UUID id){
        return wrapSuccessDataResultWithMessage(expenseTypeFacade.findById(id), "");
    }

    @GetMapping("/simplified/findById/{id}")
    public Result findByIdSimplified(@PathVariable("id") UUID id){
        return wrapSuccessDataResultWithMessage(expenseTypeFacade.findByIdSimplified(id), "");
    }

    @GetMapping("/findAll")
    public Result findAllPaged(Pageable pageable){
        return wrapSuccessDataResultWithMessage(expenseTypeFacade.findAllPaged(pageable), "");
    }

    @GetMapping("/simplified/findAll")
    public Result findAllPagedSimplified(Pageable pageable){
        return wrapSuccessDataResultWithMessage(expenseTypeFacade.findAllPagedSimplified(pageable), "");
    }

    @PostMapping(value = "/add",consumes = "application/json")
    public Result add(@RequestBody ExpenseTypeDto expenseTypeDto){
        boolean success = expenseTypeFacade.add(expenseTypeDto);
        return wrapResultWithMessage(success, "selamke");
    }
    @GetMapping(value = "/selectElement/findAll")
    public Result findAllForSelectElement() {
        List<ExpenseTypeSelectElementDto> expenseSelectElementDtos = (List<ExpenseTypeSelectElementDto>) expenseTypeFacade.findAllForSelectElement();
        return wrapSuccessDataResultWithMessage(expenseSelectElementDtos, "");
    }
    @DeleteMapping("/deleteById")
    public Result deleteById(@RequestParam("id")  UUID id) {
        boolean success = expenseTypeFacade.deleteById(id);
        return wrapResultWithMessage(success, "Deleted");
    }
}
