package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.EmployeeDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.EmployeeSimplifiedDto;
import com.bastet.bastetmanagement.models.Employee;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses = {
                OccupationMapper.class,
                BranchMapper.class,
                DepartmentMapper.class
        }
)
public interface EmployeeMapper {
    EmployeeDto employeeToEmployeeDto(Employee employee);
    Employee employeeDtoToEmployee(EmployeeDto employeeDto);
    EmployeeSimplifiedDto employeeToEmployeeSimplifiedDto(Employee employee);
    Employee employeeSimplifiedDtoToEmployee(EmployeeSimplifiedDto employeeSimplifiedDto);
}
