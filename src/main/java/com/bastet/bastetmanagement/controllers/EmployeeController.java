package com.bastet.bastetmanagement.controllers;


import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.daos.EmployeeDao;
import com.bastet.bastetmanagement.dtos.basedtos.EmployeeDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.EmployeeSimplifiedDto;
import com.bastet.bastetmanagement.facades.employee.EmployeeFacade;
import com.bastet.bastetmanagement.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController extends BaseController {
    @Resource
    private EmployeeFacade employeeFacade;

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id")UUID id){
        return wrapSuccessDataResultWithMessage(employeeFacade.findById(id), "");

    }

    @GetMapping("/simplified/findById/{id}")
    public Result findByIdSimplified(@PathVariable("id") UUID id){
        return wrapSuccessDataResultWithMessage(employeeFacade.findByIdSimplified(id), "");
    }

    @GetMapping("/findAll")
    public Result findAllPaged(Pageable pageable){
        return wrapSuccessDataResultWithMessage(employeeFacade.findAllPaged(pageable), "");
    }

    @GetMapping("/simplified/findAll")
    public Result findAllPagedSimplified(Pageable pageable){
        return wrapSuccessDataResultWithMessage(employeeFacade.findAllPagedSimplified(pageable), "");
    }
}
