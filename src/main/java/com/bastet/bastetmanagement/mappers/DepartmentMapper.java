package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.DepartmentDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CorporationSelectElementDto;
import com.bastet.bastetmanagement.dtos.selectdtos.DepartmentSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.DepartmentSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Corporation;
import com.bastet.bastetmanagement.models.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    DepartmentDto departmentToDepartmentDto(Department department);

    @Mapping(ignore = true, target = "id")
    Department departmentDtoToDepartment(DepartmentDto departmentDto);

    @Named("departmentDtoToDepartmentIdStatic")
    Department departmentDtoToDepartmentIdStatic(DepartmentDto departmentDto);

    DepartmentSimplifiedDto departmentToDepartmentSimplifiedDto(Department department);
    Department departmentSimplifiedDtoToDepartment(DepartmentSimplifiedDto departmentSimplifiedDto);

    //list versions
    List<Department> departmentDtoListTDepartmentList(List<DepartmentDto> departmentDtos);
    List<DepartmentDto> departmentListToDepartmentDtoList(List<Department> departments);
    List<DepartmentSelectElementDto> departmentListToDepartmentSelectElementDtoList(List<Department> department);

}
