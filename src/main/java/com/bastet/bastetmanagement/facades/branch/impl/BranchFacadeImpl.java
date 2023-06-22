package com.bastet.bastetmanagement.facades.branch.impl;


import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.BranchDto;
import com.bastet.bastetmanagement.dtos.selectdtos.ApplicantSelectElementDto;
import com.bastet.bastetmanagement.dtos.selectdtos.BranchSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.BranchSimplifiedDto;
import com.bastet.bastetmanagement.facades.branch.BranchFacade;
import com.bastet.bastetmanagement.mappers.BranchMapper;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Branch;
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
        return branchMapper.branchToBranchDto(branchService.findById(id));
    }

    @Override
    public BranchSimplifiedDto findByIdSimplified(UUID id) {
        return branchMapper.branchToBranchSimplifiedDto(branchService.findById(id));
    }

    @Override
    public Page<BranchDto> findAllPaged(Pageable pageable) {
        return branchService.findAllPaged(pageable).map(branch -> branchMapper.branchToBranchDto(branch));
    }

    @Override
    public Page<BranchSimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return branchService.findAllPaged(pageable).map(branch -> branchMapper.branchToBranchSimplifiedDto(branch));
    }

    public boolean add(BranchDto branchDto){
        Branch branch = branchMapper.branchDtoToBranch(branchDto);
        return branchService.add(branch);
    }

    @Override
    public List<BranchSelectElementDto> findAllForSelectElement(){
        List<Branch> branches = branchService.findAll();
        return branchMapper.branchListToBranchSelectElementDtoList(branches);
    }

    @Override
    public boolean add(Dto dto) {
        Branch branch = branchMapper.branchDtoToBranch((BranchDto) dto);
        return branchService.add(branch);
    }
    @Override
    public boolean deleteById(UUID id) {
        return branchService.deleteById(id);
    }

    @Override
    public boolean update(Dto dto) {
        Branch branch = branchMapper.branchDtoToBranchForUpdate((BranchDto) dto);
        boolean success = branchService.add(branch);
        return success;
    }
}
