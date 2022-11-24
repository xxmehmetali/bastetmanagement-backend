package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.daos.EmployeeDao;
import com.bastet.bastetmanagement.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/getAll")
    public List<Employee> getAll(){
        return employeeDao.findAll();
    }

    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee){
        return employeeDao.save(employee);
    }
}
