package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.EmployeeDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.EmployeeSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Employee;
import org.mapstruct.Mapper;

import java.util.List;

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
    //list versions
    List<Employee> employeeDtoListToEmployeeList(List<EmployeeDto> employeeDtos);
    List<EmployeeDto> employeeListToEmployeeDtoList(List<Employee> employees);

}
