package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.BranchDto;
import com.bastet.bastetmanagement.dtos.selectdtos.BranchSelectElementDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CorporationSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.BranchSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Branch;
import com.bastet.bastetmanagement.models.Corporation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                CorporationMapper.class
        }
)
public interface BranchMapper {
    BranchDto branchToBranchDto(Branch branch);

    @Mapping(ignore = true, target = "id")
    @Mapping(source = "corporation", target = "corporation", qualifiedByName = "corporationDtoToCorporationIdStatic")
    Branch branchDtoToBranch(BranchDto branchDto);

    @Named("branchDtoToBranchIdStatic")
    Branch branchDtoToBranchIdStatic(BranchDto branchDto);

    @Named("branchDtoToBranchOnlyId")
    default Branch branchDtoToBranchOnlyId(BranchDto branchDto) {
        Branch branch = new Branch();
        branch.setId( branchDto.getId() );
        return branch;
    }

    BranchSimplifiedDto branchToBranchSimplifiedDto(Branch branch);

    Branch branchSimplifiedDtoToBranch(BranchSimplifiedDto branchSimplifiedDto);

    //list versions
    List<Branch> branchDtoListToBranchList(List<BranchDto> branchDtos);

    List<BranchDto> branchListToBranchDtoList(List<Branch> branch);

    List<BranchSelectElementDto> branchListToBranchSelectElementDtoList(List<Branch> branches);

}
