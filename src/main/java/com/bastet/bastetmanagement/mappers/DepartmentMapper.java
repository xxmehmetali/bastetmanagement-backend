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
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {
                EmployeeMapper.class
        })
public interface DepartmentMapper {
    @Mapping(ignore = true, target = "departmentResponsible")
    DepartmentDto departmentToDepartmentDto(Department department);

    @Mapping(ignore = true, target = "id")
    @Mappings({
            @Mapping(source = "departmentResponsible", target = "departmentResponsible", qualifiedByName = "employeeDtoToEmployeeOnlyId")
    })
    Department departmentDtoToDepartment(DepartmentDto departmentDto);

    @Named("departmentDtoToDepartmentIdStatic")
    Department departmentDtoToDepartmentIdStatic(DepartmentDto departmentDto);

    @Mappings({
            @Mapping(source = "departmentResponsible", target = "departmentResponsible", qualifiedByName = "employeeDtoToEmployeeOnlyId")
    })
    @Named("departmentDtoToDepartmentForUpdate")
    Department departmentDtoToDepartmentForUpdate(DepartmentDto departmentDto);

    @Named("departmentDtoToDepartmentOnlyId")
    default Department departmentDtoToDepartmentOnlyId(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setId( departmentDto.getId() );
        return department;
    }

    DepartmentSimplifiedDto departmentToDepartmentSimplifiedDto(Department department);

    Department departmentSimplifiedDtoToDepartment(DepartmentSimplifiedDto departmentSimplifiedDto);

    //list versions
    List<Department> departmentDtoListTDepartmentList(List<DepartmentDto> departmentDtos);

    List<DepartmentDto> departmentListToDepartmentDtoList(List<Department> departments);

    List<DepartmentSelectElementDto> departmentListToDepartmentSelectElementDtoList(List<Department> department);

}
