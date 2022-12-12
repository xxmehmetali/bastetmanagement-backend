package com.bastet.bastetmanagement.core.configurations.mapstruct;

import com.bastet.bastetmanagement.dtos.basedtos.DepartmentDto;
import com.bastet.bastetmanagement.models.Department;
import org.mapstruct.Mapper;

@Mapper
public interface DepartmentMapper {
    DepartmentDto departmentToDepartmentDto(Department department);
    Department departmentDtoToDepartment(DepartmentDto departmentDto);
}
