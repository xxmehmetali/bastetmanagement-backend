package com.bastet.bastetmanagement.controllers;


import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.daos.DepartmentDao;
import com.bastet.bastetmanagement.dtos.basedtos.BranchDto;
import com.bastet.bastetmanagement.dtos.basedtos.DepartmentDto;
import com.bastet.bastetmanagement.dtos.selectdtos.DepartmentSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.DepartmentSimplifiedDto;
import com.bastet.bastetmanagement.facades.department.DepartmentFacade;
import com.bastet.bastetmanagement.models.Department;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController extends BaseController {
    @Resource
    private DepartmentFacade departmentFacade;

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id")UUID id){
        return wrapSuccessDataResultWithMessage(departmentFacade.findById(id), "");
    }

    @GetMapping("/simplified/findById/{id}")
    public Result findByIdSimplified(@PathVariable("id") UUID id){
        return wrapSuccessDataResultWithMessage(departmentFacade.findByIdSimplified(id), "");
    }

    @GetMapping("/findAll")
    public Result findAllPaged(Pageable pageable){
        return wrapSuccessDataResultWithMessage(departmentFacade.findAllPaged(pageable), "");
    }

    @GetMapping("/simplified/findAll")
    public Result findAllPagedSimplified(Pageable pageable){
        return wrapSuccessDataResultWithMessage(departmentFacade.findAllPagedSimplified(pageable), "");
    }

    @GetMapping(value = "/selectElement/findAll")
    public Result findAllForSelectElement() {
        List<DepartmentSelectElementDto> departmentSelectElementDtoList = (List<DepartmentSelectElementDto>) departmentFacade.findAllForSelectElement();
        return wrapSuccessDataResultWithMessage(departmentSelectElementDtoList, "");
    }

    @PostMapping(value = "/add",consumes = "application/json")
    public Result add(@RequestBody DepartmentDto departmentDto){
        boolean success = departmentFacade.add(departmentDto);
        return wrapResultWithMessage(success, "selamke");
    }
}
