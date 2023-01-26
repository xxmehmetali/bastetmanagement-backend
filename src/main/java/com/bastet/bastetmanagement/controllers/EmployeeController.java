package com.bastet.bastetmanagement.controllers;


import com.bastet.bastetmanagement.daos.EmployeeDao;
import com.bastet.bastetmanagement.dtos.basedtos.EmployeeDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.EmployeeSimplifiedDto;
import com.bastet.bastetmanagement.facades.employee.EmployeeFacade;
import com.bastet.bastetmanagement.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController extends BaseController {
    @Autowired
    private EmployeeDao employeeDao;


    @Resource
    private EmployeeFacade employeeFacade;
    @GetMapping("/findAll")
    public List<Employee> getAll(){
        return employeeDao.findAll();
    }

    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee){
        return employeeDao.save(employee);
    }

    @GetMapping("/findById/{id}")
    public EmployeeDto findById(@PathVariable("id")UUID id){
        return null;

    }

    @GetMapping("/findByBranchId/{id}")
    public List<Employee> findByBranchId(@PathVariable("id")UUID id){
        return employeeDao.findEmployeesByBranch_Id(id);
    }

    @GetMapping("/simplified/findById/{id}")
    public EmployeeSimplifiedDto findByIdSimplified(@PathVariable("id") UUID id){
        return employeeFacade.findByIdSimplified(id);
    }
}
