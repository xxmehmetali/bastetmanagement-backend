package com.bastet.bastetmanagement.facades.branch.impl;

import com.bastet.bastetmanagement.core.configurations.modelmapper.CustomModelMapper;
import com.bastet.bastetmanagement.dtos.basedtos.BranchDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.BranchSimplifiedDto;
import com.bastet.bastetmanagement.facades.branch.BranchFacade;
import com.bastet.bastetmanagement.services.branch.BranchService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component
public class BranchFacadeImpl implements BranchFacade {
    @Override
    public BranchDto findById(UUID id) {
        return null;
    }

    @Override
    public BranchSimplifiedDto findByIdSimplified(UUID id) {
        return customModelMapper.map(branchService.findById(id), BranchSimplifiedDto.class);
    }

}
