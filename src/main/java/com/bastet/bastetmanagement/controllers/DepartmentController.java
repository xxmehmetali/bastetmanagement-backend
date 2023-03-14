package com.bastet.bastetmanagement.controllers;


import com.bastet.bastetmanagement.daos.DepartmentDao;
import com.bastet.bastetmanagement.dtos.basedtos.DepartmentDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.DepartmentSimplifiedDto;
import com.bastet.bastetmanagement.facades.department.DepartmentFacade;
import com.bastet.bastetmanagement.models.Department;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController extends BaseController {
    @Resource
    private DepartmentFacade departmentFacade;

    @GetMapping("/findById/{id}")
    public DepartmentDto findById(@PathVariable("id")UUID id){
        return null;
    }

    @GetMapping("/simplified/findById/{id}")
    public DepartmentSimplifiedDto findByIdSimplified(@PathVariable("id") UUID id){
        return null;
//        return departmentFacade.findByIdSimplified(id);
    }
}
