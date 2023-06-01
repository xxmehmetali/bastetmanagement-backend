package com.bastet.bastetmanagement.controllers;


import com.bastet.bastetmanagement.core.constants.ResultConstants;
import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.dtos.basedtos.EmployeeDto;
import com.bastet.bastetmanagement.dtos.selectdtos.EmployeeSelectElementDto;
import com.bastet.bastetmanagement.facades.employee.EmployeeFacade;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Branch;
import com.bastet.bastetmanagement.models.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employee")
//@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController extends BaseController {
    @Resource
    private EmployeeFacade employeeFacade;

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id")UUID id){
        return wrapSuccessDataResultWithMessage(employeeFacade.findById(id), ResultConstants.foundMessage(Employee.class));
    }

    @GetMapping("/simplified/findById/{id}")
    public Result findByIdSimplified(@PathVariable("id") UUID id){
        return wrapSuccessDataResultWithMessage(employeeFacade.findByIdSimplified(id), ResultConstants.foundMessage(Employee.class));
    }

    @GetMapping("/findAll")
    public Result findAllPaged(Pageable pageable){
        return wrapSuccessDataResultWithMessage(employeeFacade.findAllPaged(pageable), ResultConstants.dataListedMessage(Employee.class));
    }

    @GetMapping("/simplified/findAll")
    public Result findAllPagedSimplified(Pageable pageable){
        return wrapSuccessDataResultWithMessage(employeeFacade.findAllPagedSimplified(pageable), ResultConstants.dataListedMessage(Employee.class));
    }

    @GetMapping(value = "/selectElement/findAll")
    public Result findAllForSelectElement() {
        List<EmployeeSelectElementDto> employeeSelectElementDtos = (List<EmployeeSelectElementDto>) employeeFacade.findAllForSelectElement();
        return wrapSuccessDataResultWithMessage(employeeSelectElementDtos, ResultConstants.dataListedMessageForSelection(Employee.class));
    }


    @PostMapping(value = "/add",consumes = "application/json")
    public Result add(@RequestBody EmployeeDto employeeDto){
        boolean success = employeeFacade.add(employeeDto);
        return wrapResultWithMessage(success, ResultConstants.addedMessage(Employee.class));
    }
    @DeleteMapping("/deleteById")
    public Result deleteById(@RequestParam("id")  UUID id) {
        boolean success = employeeFacade.deleteById(id);
        return wrapResultWithMessage(success, ResultConstants.deletedMessage(Employee.class));
    }

    @PostMapping(value = "/update",consumes = "application/json")
    public Result update(@RequestBody EmployeeDto employeeDto){
        employeeFacade.update(employeeDto);
        return wrapResultWithMessage(true, ResultConstants.updatedMessage(Employee.class));
    }

}
