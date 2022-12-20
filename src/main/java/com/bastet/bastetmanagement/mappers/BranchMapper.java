package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.BranchDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.BranchSimplifiedDto;
import com.bastet.bastetmanagement.models.Branch;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses = {
                CorporationMapper.class
        }
)
public interface BranchMapper {
    BranchDto branchToBranchDto(Branch branch);
    Branch branchDtoToBranch(BranchDto branchDto);
    BranchSimplifiedDto branchToBranchSimplifiedDto(Branch branch);
    Branch branchSimplifiedDtoToBranch(BranchSimplifiedDto branchSimplifiedDto);
}
