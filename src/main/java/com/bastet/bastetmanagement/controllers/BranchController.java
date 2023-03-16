package com.bastet.bastetmanagement.controllers;


import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.daos.BranchDao;
import com.bastet.bastetmanagement.dtos.basedtos.BranchDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.BranchSimplifiedDto;
import com.bastet.bastetmanagement.facades.branch.BranchFacade;
import com.bastet.bastetmanagement.models.Branch;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/branch")
public class BranchController extends BaseController {
    @Resource
    private BranchFacade branchFacade;


    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id")UUID id){
        return wrapSuccessDataResultWithMessage(branchFacade.findById(id), "");
    }

    @GetMapping("/simplified/findById/{id}")
    public Result findByIdSimplified(@PathVariable("id") UUID id){
        return wrapSuccessDataResultWithMessage(branchFacade.findByIdSimplified(id), "");
    }

    @GetMapping("/findAll")
    public Result findAllPaged(Pageable pageable){
        return wrapSuccessDataResultWithMessage(branchFacade.findAllPagedSimplified(pageable), "");
    }

    @GetMapping("/simplified/findAll")
    public Result findAllPagedSimplified(Pageable pageable) {
        return wrapSuccessDataResultWithMessage(branchFacade.findAllPagedSimplified(pageable), "");
    }

}
