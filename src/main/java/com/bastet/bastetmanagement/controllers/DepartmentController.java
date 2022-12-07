package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.daos.DepartmentDao;
import com.bastet.bastetmanagement.models.Department;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Resource
    private DepartmentDao departmentDao;

    @GetMapping("/findById/{id}")
    public Department findById(@PathVariable("id")UUID id){
        return departmentDao.findById(id).orElse(null);
    }
}
