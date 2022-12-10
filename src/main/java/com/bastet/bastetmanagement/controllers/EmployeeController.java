package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.core.configurations.modelmapper.CustomModelMapper;
import com.bastet.bastetmanagement.daos.EmployeeDao;
import com.bastet.bastetmanagement.dtos.basedtos.EmployeeDto;
import com.bastet.bastetmanagement.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @Resource
    private CustomModelMapper customModelMapper;
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
        return customModelMapper.map(employeeDao.findById(id).orElse(null), EmployeeDto.class);

    }

    @GetMapping("/findByBranchId/{id}")
    public List<Employee> findByBranchId(@PathVariable("id")UUID id){
        return employeeDao.findEmployeesByBranch_Id(id);
    }
}
