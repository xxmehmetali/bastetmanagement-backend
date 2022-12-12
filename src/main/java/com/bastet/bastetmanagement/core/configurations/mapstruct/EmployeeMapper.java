package com.bastet.bastetmanagement.core.configurations.mapstruct;

import com.bastet.bastetmanagement.dtos.basedtos.EmployeeDto;
import com.bastet.bastetmanagement.models.Employee;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {
    EmployeeDto employeeToEmployeeDto(Employee employee);
    Employee employeeDtoToEmployee(EmployeeDto employeeDto);
}
