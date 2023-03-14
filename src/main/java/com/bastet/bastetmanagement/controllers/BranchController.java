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
    public BranchDto findById(@PathVariable("id")UUID id){
        return null;
    }

    @GetMapping("/simplified/findById/{id}")
    public BranchSimplifiedDto findByIdSimplified(@PathVariable("id") UUID id){
        return (BranchSimplifiedDto) branchFacade.findByIdSimplified(id);
    }

    @GetMapping("/simplified/paged")
    public Result findBranchesSimplifiedPaged(Pageable pageable){
        return wrapDataResult(branchFacade.findAllPagedSimplified(pageable), true);
    }

//        @GetMapping("/simplified/paged")
//    @ResponseBody
//    public Result findApplicantsPaged(Pageable pageable) {
//        return wrapDataResultWithMessage(applicantFacade.findAllPaged(pageable), true, "Data listed.");
//
}
