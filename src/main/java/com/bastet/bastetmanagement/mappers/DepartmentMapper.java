package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.DepartmentDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.DepartmentSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Department;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    DepartmentDto departmentToDepartmentDto(Department department);
    Department departmentDtoToDepartment(DepartmentDto departmentDto);
    DepartmentSimplifiedDto departmentToDepartmentSimplifiedDto(Department department);
    Department departmentSimplifiedDtoToDepartment(DepartmentSimplifiedDto departmentSimplifiedDto);

    //list versions
    List<Department> departmentDtoListTDepartmentList(List<DepartmentDto> departmentDtos);
    List<DepartmentDto> departmentListToDepartmentDtoList(List<Department> departments);
}
