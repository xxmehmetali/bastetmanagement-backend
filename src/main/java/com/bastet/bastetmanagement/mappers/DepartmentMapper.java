package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.DepartmentDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.DepartmentSimplifiedDto;
import com.bastet.bastetmanagement.models.Department;
import org.mapstruct.Mapper;

@Mapper
public interface DepartmentMapper {
    DepartmentDto departmentToDepartmentDto(Department department);
    Department departmentDtoToDepartment(DepartmentDto departmentDto);
    DepartmentSimplifiedDto departmentToDepartmentSimplifiedDto(Department department);
    Department departmentSimplifiedDtoToDepartment(DepartmentSimplifiedDto departmentSimplifiedDto);
}
