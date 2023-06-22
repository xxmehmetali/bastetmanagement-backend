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
import org.mapstruct.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Mapper(
        componentModel = "spring",
        uses = {
                OccupationMapper.class,
                BranchMapper.class,
                DepartmentMapper.class,
                CurrencyMapper.class
        }
)
public interface EmployeeMapper {
    @Named("employeeToEmployeeDto")
    EmployeeDto employeeToEmployeeDto(Employee employee);

    @Mapping(ignore = true, target = "id")
    @Mappings({
            @Mapping(source = "occupation", target = "occupation", qualifiedByName = "occupationDtoToOccupationOnlyId"),
            @Mapping(source = "department", target = "department", qualifiedByName = "departmentDtoToDepartmentOnlyId"),
            @Mapping(source = "branch", target = "branch", qualifiedByName = "branchDtoToBranchOnlyId"),
            @Mapping(source = "salaryCurrency", target = "salaryCurrency", qualifiedByName = "currencyDtoToCurrencyOnlyId"),
    })
    Employee employeeDtoToEmployee(EmployeeDto employeeDto);

    @Named("employeeDtoToEmployeeOnlyId")
    default Employee employeeDtoToEmployeeOnlyId(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setId( employeeDto.getId() );
        return employee;
    }

    @Named("employeeDtoListToEmployeeListOnlyId")
    default List<Employee> employeeDtoListToEmployeeListOnlyId(List<EmployeeDto> employeeDtoList){
        if (Objects.isNull(employeeDtoList)) return null;

        return employeeDtoList.stream()
                .map(employeeDto -> employeeDtoToEmployeeOnlyId(employeeDto))
                .collect(Collectors.toList());
    }

    @Named("employeeDtoToEmployeeIdStatic")
    Employee employeeDtoToEmployeeIdStatic(EmployeeDto employeeDto);

    @Mappings({
            @Mapping(source = "occupation", target = "occupation", qualifiedByName = "occupationDtoToOccupationOnlyId"),
            @Mapping(source = "department", target = "department", qualifiedByName = "departmentDtoToDepartmentOnlyId"),
            @Mapping(source = "branch", target = "branch", qualifiedByName = "branchDtoToBranchOnlyId"),
            @Mapping(source = "salaryCurrency", target = "salaryCurrency", qualifiedByName = "currencyDtoToCurrencyOnlyId"),
    })
    @Named("employeeDtoToEmployeeForUpdate")
    Employee employeeDtoToEmployeeForUpdate(EmployeeDto employeeDto);

    @Mapping(target = "employeeFullName", expression = "java(employee.getName() + ' ' + employee.getSurname() + ' ' + '-' + ' ' + employee.getPhoneNumber())")
    EmployeeSelectElementDto employeeToEmployeeSelectElementDto(Employee employee);

    EmployeeSimplifiedDto employeeToEmployeeSimplifiedDto(Employee employee);
    Employee employeeSimplifiedDtoToEmployee(EmployeeSimplifiedDto employeeSimplifiedDto);
    //list versions
    List<Employee> employeeDtoListToEmployeeList(List<EmployeeDto> employeeDtos);
    List<EmployeeDto> employeeListToEmployeeDtoList(List<Employee> employees);


}
