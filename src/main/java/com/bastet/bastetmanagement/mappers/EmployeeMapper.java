package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.EmployeeDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CorporationSelectElementDto;
import com.bastet.bastetmanagement.dtos.selectdtos.EmployeeSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.EmployeeSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Corporation;
import com.bastet.bastetmanagement.models.Employee;
import jdk.jfr.Name;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

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

    @Mapping(ignore = true, target = "id")
    Employee employeeDtoToEmployee(EmployeeDto employeeDto);

    @Named("employeeDtoToEmployeeOnlyId")
    default Employee employeeDtoToEmployeeOnlyId(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setId( employeeDto.getId() );
        return employee;
    }

    @Named("employeeDtoToEmployeeIdStatic")
    Employee employeeDtoToEmployeeIdStatic(EmployeeDto employeeDto);

    @Mapping(target = "employeeFullName", expression = "java(employee.getName() + ' ' + employee.getSurname() + ' ' + '-' + ' ' + employee.getPhoneNumber())")
    EmployeeSelectElementDto employeeToEmployeeSelectElementDto(Employee employee);

    EmployeeSimplifiedDto employeeToEmployeeSimplifiedDto(Employee employee);
    Employee employeeSimplifiedDtoToEmployee(EmployeeSimplifiedDto employeeSimplifiedDto);
    //list versions
    List<Employee> employeeDtoListToEmployeeList(List<EmployeeDto> employeeDtos);
    List<EmployeeDto> employeeListToEmployeeDtoList(List<Employee> employees);


}
