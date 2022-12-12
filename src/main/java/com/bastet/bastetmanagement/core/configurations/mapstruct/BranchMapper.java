package com.bastet.bastetmanagement.core.configurations.mapstruct;

import com.bastet.bastetmanagement.dtos.basedtos.BranchDto;
import com.bastet.bastetmanagement.models.Branch;
import org.mapstruct.Mapper;

@Mapper
public interface BranchMapper {
    BranchDto branchToBranchDto(Branch branch);
    Branch branchDtoToBranch(BranchDto branchDto);
}
