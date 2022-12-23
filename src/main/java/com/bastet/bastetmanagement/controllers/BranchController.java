package com.bastet.bastetmanagement.controllers;


import com.bastet.bastetmanagement.daos.BranchDao;
import com.bastet.bastetmanagement.dtos.basedtos.BranchDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.BranchSimplifiedDto;
import com.bastet.bastetmanagement.facades.branch.BranchFacade;
import com.bastet.bastetmanagement.models.Branch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/branch")
public class BranchController {

    @Resource
    private BranchDao branchDao;

    @Resource
    private BranchFacade branchFacade;


    @GetMapping("/findById/{id}")
    public BranchDto findById(@PathVariable("id")UUID id){
        return customModelMapper.map(branchDao.findById(id).orElse(null), BranchDto.class);
    }

    @GetMapping("/simplified/findById/{id}")
    public BranchSimplifiedDto findByIdSimplified(@PathVariable("id") UUID id){
        return branchFacade.findByIdSimplified(id);
    }
}
