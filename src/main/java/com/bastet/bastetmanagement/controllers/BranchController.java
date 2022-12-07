package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.core.configurations.modelmapper.CustomModelMapper;
import com.bastet.bastetmanagement.daos.BranchDao;
import com.bastet.bastetmanagement.dtos.basedtos.BranchDto;
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
    private CustomModelMapper customModelMapper;

    @GetMapping("/findById/{id}")
    public BranchDto findById(@PathVariable("id")UUID id){
        return customModelMapper.map(branchDao.findById(id).orElse(null), BranchDto.class);
    }
}
