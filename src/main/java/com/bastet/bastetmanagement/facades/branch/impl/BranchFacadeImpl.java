package com.bastet.bastetmanagement.facades.branch.impl;


import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.BranchDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.BranchSimplifiedDto;
import com.bastet.bastetmanagement.facades.branch.BranchFacade;
import com.bastet.bastetmanagement.mappers.BranchMapper;
import com.bastet.bastetmanagement.services.branch.BranchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Component
public class BranchFacadeImpl implements BranchFacade {
    @Resource
    private BranchService branchService;

    @Resource
    private BranchMapper branchMapper;

    @Override
    public BranchDto findById(UUID id) {
        return null;
    }

    @Override
    public BranchSimplifiedDto findByIdSimplified(UUID id) {
        return null;
    }

    @Override
    public Page<BranchDto> findAllPaged(Pageable pageable) {
        Page pageImpl = branchService.findAllPaged(pageable);
        List<BranchDto> dtos = branchMapper.branchListToBranchDtoList(pageImpl.getContent());
        return new PageImpl<>(dtos, pageable, pageImpl.getTotalPages());
    }

    @Override
    public Page<BranchSimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return null;
    }
}
