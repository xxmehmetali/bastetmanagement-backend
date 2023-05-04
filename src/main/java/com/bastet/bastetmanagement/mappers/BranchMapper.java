package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.BranchDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.BranchSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Branch;
import org.mapstruct.Mapper;

import java.util.List;

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
    //list versions
    List<Branch> branchDtoListToBranchList(List<BranchDto> branchDtos);
    List<BranchDto> branchListToBranchDtoList(List<Branch> branch);

}
